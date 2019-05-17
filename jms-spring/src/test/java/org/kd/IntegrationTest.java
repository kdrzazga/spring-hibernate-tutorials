package org.kd;

import org.apache.activemq.broker.BrokerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.config.JmsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Import(JmsConfig.class)
@RunWith(SpringRunner.class)
public class IntegrationTest {

    @Autowired
    private SpringJmsProducer springJmsProducer;

    @Autowired
    private SpringJmsConsumer springJmsConsumer;

    @Autowired
    private BrokerService brokerService;

    @Test
    public void testContext() {
        assertNotNull(springJmsProducer);
        assertNotNull(springJmsConsumer);
        assertNotNull(brokerService);
    }

    @Test
    public void communicationTest() {

        try {
            brokerService.start();
            var message = "Ala ma kota";
            springJmsProducer.sendMessage(message);
            assertEquals(message, springJmsConsumer.receiveMessage());
            brokerService.stop();

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}