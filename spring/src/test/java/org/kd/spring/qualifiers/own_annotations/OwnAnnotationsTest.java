package org.kd.spring.qualifiers.own_annotations;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.spring.qualifiers.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class OwnAnnotationsTest {

    private Dessert iceCream;

    @Disabled//not finished
    @Test
    public void coldDessertShouldBeIceCream2WithWhippedCream() {
        assertThat(iceCream, instanceOf(IceCream2.class));
        assertThat(((IceCream2) iceCream).getAddOn(), equalTo(AddOns.WHIPPED_CREAM));
    }

    @Autowired
    @Qualifier("whipped-cream")
    public void setIceCream(Dessert iceCream) {
        this.iceCream = iceCream;
        fail("Not finished yet");
    }
}
