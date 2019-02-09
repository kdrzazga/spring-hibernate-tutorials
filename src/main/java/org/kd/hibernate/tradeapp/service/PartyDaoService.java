package org.kd.hibernate.tradeapp.service;

import org.kd.hibernate.tradeapp.entity.Party;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public List<Party> get() {
        Query query = entityManager.createQuery("SELECT id, name, shortname FROM Party");

        return query.getResultList();
    }
}
