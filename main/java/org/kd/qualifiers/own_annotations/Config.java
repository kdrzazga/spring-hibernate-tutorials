package org.kd.qualifiers.own_annotations;

import org.kd.qualifiers.Dessert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    @Qualifier("nutty")
    public Dessert iceCreamWithNuts(){
        IceCream2 iceCream = new IceCream2();
        iceCream.setAddOn(AddOns.NUTS);
        return iceCream;
    }

    @Bean
    @Creamy
    public Dessert iceCreamWithWhippedCream(){
        IceCream2 iceCream = new IceCream2();
        iceCream.setAddOn(AddOns.WHIPPED_CREAM);
        return iceCream;
    }
}
