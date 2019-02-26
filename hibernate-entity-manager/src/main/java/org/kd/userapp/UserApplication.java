package org.kd.userapp;

import org.kd.userapp.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(UserApplication.class, args);
    }

    public static User getUserFromContext() {
        return context.getBean(User.class);//no such bean
    }

    public static void stop(){
        context.close();
    }



}

