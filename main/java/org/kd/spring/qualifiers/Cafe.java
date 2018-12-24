package org.kd.spring.qualifiers;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Qualifier;

@Named
public class Cafe {

    private Dessert dessert;

    @Inject
    @Qualifier("iceCream")
    public void setDessert(Dessert dessert){
        this.dessert = dessert;
    }

    public Dessert getDessert() {
        return dessert;
    }
}
