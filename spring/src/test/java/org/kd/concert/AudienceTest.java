package org.kd.concert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.spring.aspects.concert.AspectConcertConfig;
import org.kd.spring.aspects.concert.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = {AspectConcertConfig.class})
@ExtendWith(SpringExtension.class)
public class AudienceTest {

    @Autowired
    Performance testPerformance;

    @Test
    public void testPerformanceCall() {
        testPerformance.perform();
    }
}
