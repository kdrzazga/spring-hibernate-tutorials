package org.kd.qualifiers.own_annotations;

import org.kd.qualifiers.Dessert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Cold
@Creamy //=@Qualifier("creamy")
public class IceCream2 implements Dessert {

    private AddOns addOn = AddOns.NONE;

    @Override
    public void writeDescription() {
        System.out.println("Ice Creeam 2, troche inne niz Ice Cream");
    }

    public AddOns getAddOn() {
        return addOn;
    }

    public void setAddOn(AddOns addOn) {
        this.addOn = addOn;
    }
}
