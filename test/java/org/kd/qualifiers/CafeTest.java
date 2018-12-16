package org.kd.qualifiers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= QualifiersConfig.class)
public class CafeTest {
    @Inject
    private Cafe cafe;

    @Test
    public void cafeShouldNotBeNull(){
        assertNotNull(cafe);
    }

    @Test
    public void dessertShouldBeIceCream(){
        assertThat(cafe.getDessert(), instanceOf(IceCream.class));
    }
}
