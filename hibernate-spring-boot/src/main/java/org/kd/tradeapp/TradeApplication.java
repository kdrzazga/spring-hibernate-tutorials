package org.kd.tradeapp;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TradeApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(TradeApplication.class, args);
        writeInfo();
    }

    public static void stop(){
        context.stop();
        context.close();
    }

    private static void writeInfo() {
        LoggerFactory.getLogger(TradeApplication.class).info("\nH2 database link: http://localhost:8080/h2-console");
        LoggerFactory.getLogger(TradeApplication.class).info("Make sure h2 console is enabled in application.properties");
    }
}
