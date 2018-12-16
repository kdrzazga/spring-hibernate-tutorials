package org.kd.stereo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.kd.stereo")// dla org.kd.knights wywala sie, bo nie znajdzie
@ComponentScan(basePackageClasses = {CompactDisc.class }) //lae ten znajdzie
public class CDPlayerConfig {
}
