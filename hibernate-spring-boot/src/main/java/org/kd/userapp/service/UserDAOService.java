package org.kd.userapp.service;

import org.kd.userapp.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(User user) {

        entityManager.persist(user);
        return user.getId();
    }

    public User getTransactByPrimaryKey(long id) {
        return entityManager.find(User.class, id);
    }
}