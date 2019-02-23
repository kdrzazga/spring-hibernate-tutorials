package org.kd.tradeapp.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.kd.tradeapp.entity.Fund;
import org.kd.tradeapp.entity.Party;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PartyDaoService {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(Party party) {
        entityManager.persist(party);
        return party.getId();
    }

    public boolean isPersisted(Party party){
        return entityManager.contains(party);
    }

    public void detach(Party party){
        entityManager.detach(party);
    }

    public List<Party> getAllParties() {
        var query = entityManager.createQuery("SELECT id, name, shortname FROM Party");

        return query.getResultList();
    }

    public Party get(long id) {
        var session = getSession();
        var crBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Party> query = crBuilder.createQuery(Party.class);
        Root<Party> root = query.from(Party.class);
        query.select(root).where(crBuilder.equal(root.get("id"), id));//SELECT from Party WHERE id=id
        Query<Party> q = session.createQuery(query);
        return q.getSingleResult();
    }

    public Party get(String shortname) {
        var session = getSession();
        var crBuilder = session.getCriteriaBuilder();
        var query = crBuilder.createQuery(Party.class);
        var root = query.from(Party.class);
        query.select(root).where(crBuilder.equal(root.get("shortname"), shortname));//SELECT from Party WHERE id=id
        var q = session.createQuery(query);
        return q.getSingleResult();
    }

    public List<Fund> getAssociatedFunds(long partyId){
        var session = getSession();
        var crBuilder = session.getCriteriaBuilder();
        var query = crBuilder.createQuery(Fund.class);
        var root = query.from(Fund.class);
        query.select(root).where(crBuilder.equal(root.get("party_id"), partyId));//SELECT from Funds WHERE party_id=partyId
        var q = session.createQuery(query);
        return q.getResultList();
    }

    private Session getSession() {
        Session session = null;
        if (entityManager == null
                || (session = entityManager.unwrap(Session.class)) == null) {

            throw new NullPointerException();
        }
        return session;
    }
}
