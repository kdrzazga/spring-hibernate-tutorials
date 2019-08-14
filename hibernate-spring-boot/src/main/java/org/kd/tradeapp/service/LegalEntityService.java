package org.kd.tradeapp.service;

import org.springframework.stereotype.Repository;

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
