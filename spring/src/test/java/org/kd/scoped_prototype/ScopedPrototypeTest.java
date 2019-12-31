package org.kd.scoped_prototype;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.spring.scope_prototype.PrototypedComponent;
import org.kd.spring.scope_prototype.ScopedPrototypeConfig;
import org.kd.spring.scope_prototype.SingletonComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= ScopedPrototypeConfig.class)
public class ScopedPrototypeTest {

    @Autowired
    private PrototypedComponent comp1;

    @Autowired
    private PrototypedComponent comp2;

    @Autowired
    private SingletonComponent compSingle1;

    @Autowired
    private SingletonComponent compSingle2;

    @Test
    public void testPrototypes(){
        assertNotNull(comp1);
        assertNotNull(comp2);

        comp1.setId(1);
        comp2.setId(2);

        assertEquals(1, comp1.getId());
        assertEquals(2, comp2.getId());
    }
    @Test
    public void testSingletons(){
        assertNotNull(compSingle1);
        assertNotNull(compSingle2);

        compSingle1.setId(1);
        compSingle2.setId(2);

        assertNotEquals(1, compSingle1.getId());
        assertEquals(2, compSingle1.getId());
        assertEquals(2, compSingle2.getId());
    }
}
