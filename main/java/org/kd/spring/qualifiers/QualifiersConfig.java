package org.kd.spring.qualifiers;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "org.kd.spring.qualifiers")// dla org.kd.spring.knights wywala sie, bo nie znajdzie
public class QualifiersConfig {
}
