package org.kd.qualifiers.own_annotations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.qualifiers.Cafe;
import org.kd.qualifiers.Dessert;
import org.kd.qualifiers.IceCream;
import org.kd.qualifiers.QualifiersConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class OwnAnnotationsTest {

    private Dessert iceCream;

    @Test
    public void coldDessertShouldBeIceCream2WithWhippedCream() {
        assertThat(iceCream, instanceOf(IceCream2.class));
        assertThat(((IceCream2) iceCream).getAddOn(), equalTo(AddOns.WHIPPED_CREAM));
    }

    @Autowired
    @Qualifier("whipped-cream")
    public void setIceCream(Dessert iceCream) {
        this.iceCream = iceCream;
    }
}
