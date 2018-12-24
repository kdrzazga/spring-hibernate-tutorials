package org.kd.spring.qualifiers.own_annotations;

import org.kd.spring.qualifiers.Dessert;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("whipped-cream")
public class WhippedCream implements Dessert{
    @Override
    public void writeDescription() {

    }
}
