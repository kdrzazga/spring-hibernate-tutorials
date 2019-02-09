package org.kd.spring.qualifiers.own_annotations;

import org.kd.spring.qualifiers.Dessert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @Qualifier("nutty")
    public Dessert iceCreamWithNuts(){
        var iceCream = new IceCream2();
        iceCream.setAddOn(AddOns.NUTS);
        return iceCream;
    }

    @Bean
    @Creamy
    public Dessert iceCreamWithWhippedCream(){
        var iceCream = new IceCream2();
        iceCream.setAddOn(AddOns.WHIPPED_CREAM);
        return iceCream;
    }
}
