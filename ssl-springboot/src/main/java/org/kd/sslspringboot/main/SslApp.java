package org.kd.sslspringboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SslApp {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(SslApp.class, args);

        if (context != null) {
            List.of("SERVER STARTED."
            )
                    .forEach(System.out::println);
        }
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}