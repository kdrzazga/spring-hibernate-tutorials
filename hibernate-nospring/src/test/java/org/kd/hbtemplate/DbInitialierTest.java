package org.kd.hbtemplate;

import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.kd.hbtemplate.entity.Country;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class DbInitialierTest {

    @Test
    public void testDbInit() throws SQLException {
        new DbInitializer().init();

        var sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        var session = sessionFactory.openSession();
        var builder = session.getCriteriaBuilder();
        var criteria = builder.createQuery(Country.class);
        criteria.from(Country.class);
        var countries = session.createQuery(criteria).getResultList();
        session.close();

        assertNotNull(countries);
    }
}
