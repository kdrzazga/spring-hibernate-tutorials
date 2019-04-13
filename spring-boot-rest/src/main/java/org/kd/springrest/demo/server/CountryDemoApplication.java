package org.kd.springrest.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CountryDemoApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(CountryDemoApplication.class, args);

        if (context != null){
            System.out.println("SERVER STARTED.");
            System.out.println("Example requests:");
            System.out.println("http://localhost:8083/countries");
            System.out.println("http://localhost:8083/country/0");
            System.out.println("http://localhost:8083/country/1");
            System.out.println("http://localhost:8083/country/2");
            System.out.println();
            System.out.println("http://localhost:8083/response-entity-builder-with-http-headers");
        }
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}
