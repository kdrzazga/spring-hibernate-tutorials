package org.kd.tradeapp.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.kd.tradeapp.entity.Fund;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class FundDaoService{

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(Fund fund) {
        entityManager.persist(fund);
        return fund.getId();
    }

    public boolean isPersisted(Fund fund){
        return entityManager.contains(fund);
    }

    public void detach(Fund fund){
        entityManager.detach(fund);
    }

    public List<Fund> getAllFunds(){
        var query = entityManager.createQuery("SELECT id, name, shortname, units, party_id FROM Fund");

        return query.getResultList();
    }

    public Fund get(long id) {
        var session = getSession();
        var crBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Fund> query = crBuilder.createQuery(Fund.class);
        Root<Fund> root = query.from(Fund.class);
        query.select(root).where(crBuilder.equal(root.get("id"), id));//SELECT from Fund WHERE id=id
        Query<Fund> q = session.createQuery(query);
        return q.getSingleResult();
    }

    public Fund get(String shortname) {
        var session = getSession();
        var crBuilder = session.getCriteriaBuilder();
        var query = crBuilder.createQuery(Fund.class);
        var root = query.from(Fund.class);
        query.select(root).where(crBuilder.equal(root.get("shortname"), shortname));//SELECT from Fund WHERE id=id
        var q = session.createQuery(query);
        return q.getSingleResult();
    }

    public void update(Fund fund) {
        var session = getSession();
        session.update(fund);
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
