package org.kd;

import org.hibernate.Metamodel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import javax.persistence.*;
import javax.persistence.metamodel.EntityType;
import java.util.function.Consumer;
import java.util.function.Function;

public class EntityManagerTemplate {

    private static EntityManagerFactory emf;

    private ThreadLocal<EntityManager> entityManagerThreadLocal = new ThreadLocal<>();
    private String unitName = "jpatraining";

    public EntityManager createEntityManager() {
        if (emf == null) {//fabryka jest singletonem
            emf = Persistence.createEntityManagerFactory(unitName);//stawia Hb, kosztowne
        }
        getStatistics().setStatisticsEnabled(true);
        return emf.createEntityManager();
    }

    public Statistics getStatistics() {
        return emf.unwrap(SessionFactory.class).getStatistics();//dostajemy sie do sesji, wyluskujemy ja z EM
    }

    public void close() {
        getEntityManager().close();
        entityManagerThreadLocal.remove();
    }

    public EntityManager getEntityManager() {
        EntityManager em = entityManagerThreadLocal.get();
        if (em == null) {
            em = createEntityManager();
            entityManagerThreadLocal.set(em);
        }
        return em;
    }

    //imperatywne zarzadzanie transakcjami. W deklaratywnym zarzadzaniu jak w springu, gdzies zagrzebany jest podobny kod
    public <T> T executeInTx(Function<EntityManager, T> fun) {//szablon, ktory tworzy EM, potem transakcje
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            T result = fun.apply(em);
            tx.commit();  // po wykonaniu fcji komituje   (commit wykonuje flusha)
            return result;  // i zwraca wynik
        } catch (RuntimeException ex) {
            tx.rollback();
            throw ex;
        }
    }

    //czyszczenie przed kazdym testem
    public void cleanDb() {
        executeInTx((em) -> {
            Session session = em.unwrap(Session.class);
            Metamodel hibernateMetadata = session.getSessionFactory().getMetamodel();
            session.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
            hibernateMetadata.getEntities().stream()
                    .map(this::getTableName)
                    .forEach(tableName -> session.createNativeQuery("TRUNCATE TABLE " + tableName)
                            .executeUpdate()
                    );
            session.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
        });
    }

    private String getTableName(EntityType<?> entityType) {
        Table table = entityType.getJavaType().getAnnotation(Table.class);
        return table == null ? entityType.getName() : table.name();
    }

    public void executeInTx(Consumer<EntityManager> consumer) {
        executeInTx((em) -> {
            consumer.accept(em);
            return null;
        });
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
