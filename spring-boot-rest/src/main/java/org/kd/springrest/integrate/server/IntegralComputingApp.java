package org.kd.springrest.integrate.server;

import org.kd.springrest.demo.server.CountryDemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class IntegralComputingApp {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(IntegralComputingApp.class, args);

        if (context != null) {
            List.of("".repeat(5)
                    , "SERVER STARTED."
                    , "This is just a silly REST Backend Service for estimating integrals. Example request:"
                    , "To compute integral S sin x dx for interval -PI to PI: http://localhost:8083/sin/-3.141/3.141"
                    , "S log10 x dx for (1-10): http://localhost:8083/log10/1/10"
                    , ""
                    , "Available are single-argument functions from java.lang.Math class: sin, cos, tan, log10, abs, exp, etc."
                    , "Server has no access to services in " + CountryDemoApplication.class.getPackageName()
                            + ", as it's a different Spring App.")
                    .forEach(System.out::println);
        }
    }

}
