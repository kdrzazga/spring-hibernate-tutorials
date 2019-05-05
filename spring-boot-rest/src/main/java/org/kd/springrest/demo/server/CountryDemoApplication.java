package org.kd.springrest.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class CountryDemoApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(CountryDemoApplication.class, args);

        if (context != null) {
            List.of("SERVER STARTED."
                    , "Example requests:"
                    , "http://localhost:8083/countries"
                    , "http://localhost:8083/country/0"
                    , "http://localhost:8083/country/1"
                    , "http://localhost:8083/country/2"
                    , "\n"
                    , "http://localhost:8083/response-entity-builder-with-http-headers")
                    .forEach(System.out::println);
        }
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}
