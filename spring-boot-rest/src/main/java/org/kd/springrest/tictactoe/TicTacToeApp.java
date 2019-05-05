package org.kd.springrest.tictactoe;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TicTacToeApp {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(TicTacToeApp.class, args);

        if (context != null){
            System.out.println("\n".repeat(5));
            System.out.println("SERVER STARTED.");
            System.out.println("NOT IMPLEMENTED YET!!!!");

        }
    }

}