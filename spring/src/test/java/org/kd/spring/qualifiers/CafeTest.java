package org.kd.spring.qualifiers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = QualifiersConfig.class)
public class CafeTest {
    @Inject
    private Cafe cafe;

    @Test
    public void cafeShouldNotBeNull() {
        assertNotNull(cafe);
    }

    @Test
    public void dessertShouldBeIceCream() {
        assertThat(cafe.getDessert(), instanceOf(IceCream.class));
    }
}
