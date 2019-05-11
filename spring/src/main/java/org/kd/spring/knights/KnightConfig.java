package org.kd.spring.knights;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class KnightConfig {

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public List<Knight> knights() {
        return List.of(new BraveKnight(quest()),
                new DamselRescuingKnight()
        );
    }
}
