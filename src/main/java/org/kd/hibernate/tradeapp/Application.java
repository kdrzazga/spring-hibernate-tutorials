package org.kd.hibernate.tradeapp;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Application.class, args);
        writeInfo();
    }

    private static void writeInfo() {
        LoggerFactory.getLogger(org.kd.hibernate.userapp.Application.class).info("\nH2 database link: http://localhost:8080/h2-console");
        LoggerFactory.getLogger(org.kd.hibernate.userapp.Application.class).info("Make sure h2 console is enabled in application.properties");
    }
}
