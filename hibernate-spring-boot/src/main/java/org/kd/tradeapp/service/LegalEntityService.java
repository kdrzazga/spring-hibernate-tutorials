package org.kd.tradeapp.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.kd.tradeapp.entity.LegalEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class LegalEntityService {
/*
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public LegalEntity get(long id){
        var session = getSession();
        var crBuilder = session.getCriteriaBuilder();
        CriteriaQuery<LegalEntity> query = crBuilder.createQuery(LegalEntity.class);
        Root<LegalEntity> root = query.from(LegalEntity.class);
        query.select(root).where(crBuilder.equal(root.get("id"), id));
        Query<LegalEntity> q = session.createQuery(query);
        return q.getSingleResult();
    }


    protected Session getSession() {
        Session session;
        if (entityManager == null
                || (session = entityManager.unwrap(Session.class)) == null) {

            throw new NullPointerException();
        }
        return session;
    }
*/
}
