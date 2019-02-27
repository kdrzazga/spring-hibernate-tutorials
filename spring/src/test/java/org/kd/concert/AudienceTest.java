package org.kd.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.spring.aspects.concert.AspectConcertConfig;
import org.kd.spring.aspects.concert.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AspectConcertConfig.class)
public class AudienceTest {

    @Autowired
    Performance testPerformance;

    @Test
    public void testPerformaceCall() {
        testPerformance.perform();
    }
}
