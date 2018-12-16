package org.kd.qualifiers;

import javax.inject.Named;

@Named
public class IceCream implements Dessert {

    private final static String DESCRIPTION = "Tasty cooling ice-cream";

    @Override
    public void writeDescription() {
        System.out.println(DESCRIPTION);
    }
}
