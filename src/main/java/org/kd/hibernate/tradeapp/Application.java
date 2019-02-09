package org.kd.hibernate.tradeapp;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
        writeInfo();
    }

    public static void stop(){
        context.stop();
        context.close();

    }

    private static void writeInfo() {
        LoggerFactory.getLogger(org.kd.hibernate.userapp.Application.class).info("\nH2 database link: http://localhost:8080/h2-console");
        LoggerFactory.getLogger(org.kd.hibernate.userapp.Application.class).info("Make sure h2 console is enabled in application.properties");
    }
}
