package org.kd.hibernate.userapp;

import org.kd.hibernate.userapp.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
    }

    public static User getUserFromContext() {
        return context.getBean(User.class);//no such bean
    }

    public static void stop(){
        context.close();
    }



}

