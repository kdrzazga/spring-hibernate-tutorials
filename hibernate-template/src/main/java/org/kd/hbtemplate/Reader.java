package org.kd.hbtemplate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.kd.hbtemplate.entity.Country;

public class Reader {

    private SessionFactory sessionFactory;

    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();
    }

    public void read() {
        try {

            setUp();

            var session = sessionFactory.openSession();
            var builder = session.getCriteriaBuilder();
            var criteria = builder.createQuery(Country.class);
            criteria.from(Country.class);

            var funds = session.createQuery(criteria).getResultList();
            session.close();

        } catch (Exception e) {

        }
    }
}
