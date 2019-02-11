package org.kd.spring.qualifiers;

import javax.inject.Named;

@Named
public class Cake implements Dessert{

    private final static String DESCRIPTION = "Sweet apple pie";

    @Override
    public void writeDescription() {
        System.out.println(DESCRIPTION);
    }
}
