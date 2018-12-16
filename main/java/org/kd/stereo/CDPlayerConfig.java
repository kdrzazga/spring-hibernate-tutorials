package org.kd.stereo;

import org.kd.stereo.media.CDPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.kd.stereo")// dla org.kd.knights wywala sie, bo nie znajdzie
@ComponentScan(basePackageClasses = {CompactDisc.class }) //lae ten znajdzie
public class CDPlayerConfig {

    @Bean
    public CDPlayer cdPlayer() {
        return new CDPlayer(stateOfMindReport());
    }

    @Bean
    public CompactDisc stateOfMindReport() {
        return new StateOfMindReport();
    }
}
