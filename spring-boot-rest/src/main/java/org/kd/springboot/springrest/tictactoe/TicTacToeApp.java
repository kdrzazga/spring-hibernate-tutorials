package org.kd.springboot.springrest.tictactoe;


import org.kd.springboot.springrest.tictactoe.repository.TicTacToeLoginRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class TicTacToeApp {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(TicTacToeApp.class, args);

        var loginRepo = new TicTacToeLoginRepository();

        if (context != null) {
            List.of("\n".repeat(3)
                    , "SERVER STARTED."
                    , "http://localhost:8083/place/1,1"
                    , "Credentials:"
                    , loginRepo.getPlayerO().getUsername() + ", pass"
                    , loginRepo.getPlayerX().getUsername() + ", pass"
                    , "IMPLEMENTATION NOT FINISHED YET!!!!")
                    .forEach(System.out::println);

        }
    }

}