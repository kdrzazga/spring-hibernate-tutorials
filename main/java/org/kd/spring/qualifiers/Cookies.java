package org.kd.spring.qualifiers;

import javax.inject.Named;

@Named
public class Cookies implements Dessert {

    private final static String DESCRIPTION = "Sweet butter cookies";

    @Override
    public void writeDescription() {
        System.out.println(DESCRIPTION);
    }
}
