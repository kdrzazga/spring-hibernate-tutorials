package org.kd.spring.aspects.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConcertConfig {

    @Bean
    public Performance createPerformance() {
        return new ClownPerformance();
    }

}
