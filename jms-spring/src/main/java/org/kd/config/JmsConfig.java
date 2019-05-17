package org.kd.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.kd.SpringJmsConsumer;
import org.kd.SpringJmsProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.net.URI;

public class JmsConfig {

    private ConnectionFactory connectionFactory() {
        var factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("tcp://localhost:61616");
        return factory;
    }

    private ActiveMQQueue messageDestination() {
        return new ActiveMQQueue("messageQueue1");
    }

    private JmsTemplate jmsTemplate() {
        var template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        template.setReceiveTimeout(10000);
        return template;
    }

    @Bean
    public SpringJmsProducer springJmsProducer() {
        var producer = new SpringJmsProducer();
        producer.setDestination(messageDestination());
        producer.setJmsTemplate(jmsTemplate());
        return producer;
    }

    @Bean
    public SpringJmsConsumer springJmsConsumer() {
        var consumer = new SpringJmsConsumer();
        consumer.setDestination(messageDestination());
        consumer.setJmsTemplate(jmsTemplate());
        return consumer;
    }

    @Bean
    public BrokerService brokerService() {
        try {
            return BrokerFactory.createBroker(new URI(
                    "broker:(tcp://localhost:61616)"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
