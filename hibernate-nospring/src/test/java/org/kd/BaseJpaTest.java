package org.kd;

import org.junit.Before;

public class BaseJpaTest {

    protected final EntityManagerTemplate template = new EntityManagerTemplate();

    @Before
    public void cleanDb() {
        template.cleanDb();
    }

}
