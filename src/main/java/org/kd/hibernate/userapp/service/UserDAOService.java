package org.kd.hibernate.userapp.service;

import org.kd.hibernate.userapp.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(User user){

        entityManager.persist(user);
        return user.getId();
    }

}
