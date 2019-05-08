package org.kd.config;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import org.kd.model.Board;
import org.kd.model.BoardKeyListener;
import org.kd.model.Game;
import org.kd.model.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    @Bean
    public Canvas canvas() {
        return new Canvas(264, 250);
    }

    public Group root() {
        Group root = new Group();
        root.getChildren().add(canvas());
        return root;
    }

    @Bean
    public Scene scene() {
        Scene scene = new Scene(root());
        //TODO s.setOnKeyPressed(new BoardKeyListener(board));
        return scene;
    }

    @Bean
    public Game game() {
        Game game = new Game();
        game.board = board();
        return game;
    }

    @Bean
    public Board board() {
        Board board = new Board(canvas().getGraphicsContext2D());
        board.setVehicle(vehicle());
        board.setBoardKeyListener(new BoardKeyListener(board));
        return board;
    }

    public Vehicle vehicle() {
        return new Vehicle();
    }

}
