package org.kd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.metamodel.EntityType;
import java.util.function.Consumer;
import java.util.function.Function;

public class EntityManagerTemplate {

    private static EntityManagerFactory emFactorySingleton;

    private ThreadLocal<EntityManager> entityManagerThreadLocal = new ThreadLocal<>();
    private String unitName = "hibernate-without-spring-tutorial";

    public EntityManager createEntityManager() {
        if (emFactorySingleton == null) {
            emFactorySingleton = Persistence.createEntityManagerFactory(unitName);//set up Hb, quite time conuming, but not as much as Spring
        }
        getStatistics().setStatisticsEnabled(true);
        return emFactorySingleton.createEntityManager();
    }

    public Statistics getStatistics() {
        return emFactorySingleton.unwrap(SessionFactory.class).getStatistics();//dostajemy sie do sesji, wyluskujemy ja z EM
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

    //Impreative transactions management (imerative -> usinmg commands). Spring uses declarative management (with @-style declarations)
    // and has something similar buried inside
    public <T> T executeInTx(Function<EntityManager, T> fun) {
        var em = getEntityManager();
        var tx = em.getTransaction();

        tx.begin();
        try {
            T result = fun.apply(em);
            tx.commit();  //executes given function and commits
            return result;
        } catch (RuntimeException ex) {
            tx.rollback();
            throw ex;
        }
    }

    public void executeInTx(Consumer<EntityManager> consumer) {
        executeInTx((em) -> {
            consumer.accept(em);
            return null;//prevents infinity loop and StackOverflow Exception
        });
    }

    public void cleanDb() {

        executeInTx(em -> {
            var session = em.unwrap(Session.class);
            var hibernateMetadata = session.getSessionFactory().getMetamodel();
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
        var table = entityType.getJavaType().getAnnotation(Table.class);
        return table == null ? entityType.getName() : table.name();
    }


    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
