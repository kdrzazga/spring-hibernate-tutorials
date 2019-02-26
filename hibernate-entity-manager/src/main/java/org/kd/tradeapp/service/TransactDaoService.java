package org.kd.tradeapp.service;

import org.hibernate.Session;
import org.kd.tradeapp.entity.Fund;
import org.kd.tradeapp.entity.Transact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TransactDaoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PartyDaoService partyDaoService;

    @Autowired
    private FundDaoService fundDaoService;

    @Transactional
    public Transact getTransactByPrimaryKey(int id) {
        return entityManager.find(Transact.class, id);
    }

    @Transactional
    public void removeTransactByPrimaryKey(int id) {
        var entity = entityManager.find(Transact.class, id);
        //entityManager.getTransaction().begin();// this is handled by Spring @Transactional
        entityManager.remove(entity);
        //entityManager.getTransaction().commit();// this is handled by Spring @Transactional too
    }

    @Transactional
    public List<Transact> getAllTransacts() {
        var session = entityManager.unwrap(Session.class);
        var builder = session.getCriteriaBuilder();
        var criteria = builder.createQuery(Transact.class);
        criteria.from(Transact.class);

        var transacts = session.createQuery(criteria).getResultList();
        session.close();
        return transacts;
    }

    @Transactional
    public List<Transact> getTransactByFundId(int fundId) {
        var session = entityManager.unwrap(Session.class);
        var builder = session.getCriteriaBuilder();
        var criteria = builder.createQuery(Transact.class);

        var root = criteria.from(Transact.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("dest_fund_id"), fundId));

        var transacts = session.createQuery(criteria).getResultList();
        session.close();
        return transacts;
    }

    @Transactional
    public int book(long sourceFundIs, long destFundId, float units) {

        var destFund = fundDaoService.get(destFundId);
        var sourceFund = fundDaoService.get(sourceFundIs);

        if (destFund == null || sourceFund == null) return -1;

        return (destFund.getParty_id() == sourceFund.getParty_id())
                ? bookInternalTransact(sourceFund, destFund, units)
                : bookExternalTransact();
    }

    private int bookInternalTransact(Fund sourceFund, Fund destFund, float units) {
        if (sourceFund.getUnits() < units) return -1;

        sourceFund.setUnits(sourceFund.getUnits() - units);
        destFund.setUnits(destFund.getUnits() + units);

        fundDaoService.update(sourceFund);
        fundDaoService.update(destFund);
        return addNewTransact(sourceFund.getId(), destFund.getId(), units, true);
    }

    private int bookExternalTransact() {
        throw new RuntimeException("Not implemented yet");
        //TODO implement
    }

    private int addNewTransact(int sourceFundId, int destFundId, float units, boolean internal){
        var newTransact = new Transact(sourceFundId, destFundId, units, internal);

        entityManager.persist(newTransact);
        entityManager.flush();

        return newTransact.getId();
    }

}
