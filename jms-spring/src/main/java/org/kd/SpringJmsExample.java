package org.kd;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URI;

public class SpringJmsExample {
    public static void main(String[] args) throws Exception {

        System.out.println("Please be patient...\n\n");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        BrokerService broker = BrokerFactory.createBroker(new URI(
                "broker:(tcp://localhost:61616)"));
        broker.start();
        try {
            var springJmsProducer =  context
                    .getBean("springJmsProducer", SpringJmsProducer.class);
            springJmsProducer.sendMessage("Hi");

            var springJmsConsumer = context
                    .getBean("springJmsConsumer", SpringJmsConsumer.class);
            System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
        } finally {
            broker.stop();
            context.close();
        }
    }
}
