package org.kd.manyto1.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.kd.manyto1.entity.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PostDaoService {

    @PersistenceContext
    private EntityManager entityManager;

   @Transactional
    public void addToDatabase(List<Post> posts) {

       posts.forEach(post -> {
           entityManager.persist(post);
                   post.getComments()
                           .forEach(comment -> entityManager.persist(comment));

       });

        entityManager.flush();
    }

    @Transactional
    public List<Post> getAllPosts() {
        CriteriaQuery<Post> query = getSession().getCriteriaBuilder().createQuery(Post.class);
        Root<Post> root = query.from(Post.class);
        query.select(root);
        Query<Post> q = getSession().createQuery(query);

        return q.getResultList();
    }

    private Session getSession() {
        Session session;
        if (entityManager == null
                || (session = entityManager.unwrap(Session.class)) == null) {

            throw new NullPointerException();
        }
        return session;
    }

}
