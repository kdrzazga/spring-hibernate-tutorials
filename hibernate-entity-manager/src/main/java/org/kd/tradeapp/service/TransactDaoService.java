package org.kd.tradeapp.service;

import org.hibernate.Session;
import org.kd.tradeapp.entity.Transact;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TransactDaoService {

    @PersistenceContext
    private EntityManager entityManager;

    public Transact getTransactByPrimaryKey(int id) {
        return entityManager.find(Transact.class, id);
    }

    public void removeTransactByPrimaryKey(int id) {
        var entity = entityManager.find(Transact.class, id);
        //entityManager.getTransaction().begin();// this is handled by Spring @Transactional
        entityManager.remove(entity);
        //entityManager.getTransaction().commit();// this is handled by Spring @Transactional too
    }

    public List<Transact> getAllTransacts() {
        var session = entityManager.unwrap(Session.class);
        var builder = session.getCriteriaBuilder();
        var criteria = builder.createQuery(Transact.class);
        criteria.from(Transact.class);

        var transacts = session.createQuery(criteria).getResultList();
        session.close();
        return transacts;
    }

    public List<Transact> getTransactByFundId(int fundId) {
        var session = entityManager.unwrap(Session.class);
        var builder = session.getCriteriaBuilder();
        var criteria = builder.createQuery(Transact.class);

        var root = criteria.from(Transact.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("fund_id"), fundId));

        var transacts = session.createQuery(criteria).getResultList();
        session.close();
        return transacts;
    }

}
