package org.kd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@Import(Config.class)
@RunWith(SpringRunner.class)
public class IntegrationTest {

    @Autowired
    private SpringJmsProducer springJmsProducer;

    @Autowired
    private SpringJmsConsumer springJmsConsumer;

    @Test
    public void testContext(){
        assertNotNull(springJmsProducer);
        assertNotNull(springJmsConsumer);
    }
}
