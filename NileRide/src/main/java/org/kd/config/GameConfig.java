package org.kd.config;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import org.kd.model.Board;
import org.kd.model.BoardKeyListener;
import org.kd.model.Game;
import org.kd.model.Vehicle;
import org.kd.view.Drawer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    @Bean
    public Canvas canvas() {
        return new Canvas(Board.WIDTH, Board.HEIGHT);
    }

    public Group root() {
        Group root = new Group();
        root.getChildren().add(canvas());
        return root;
    }

    @Bean
    public Scene scene() {
        Scene scene = new Scene(root());
        scene.setOnKeyPressed(new BoardKeyListener(board()));
        return scene;
    }

    @Bean
    public Game game() {
        Game game = new Game();
        game.board = board();
        game.drawer = drawer();

        return game;
    }

    private Drawer drawer() {
        var gc = canvas().getGraphicsContext2D();
        return new Drawer(gc);
    }

    @Bean
    public Board board() {
        var board = new Board();
        board.setVehicle(vehicle());
        board.setBoardKeyListener(new BoardKeyListener(board));
        board.setEnemy(enemy());
        return board;
    }

    public Vehicle vehicle() {
        var vehicle = new Vehicle();
        vehicle.setX(Board.WIDTH / 2);
        vehicle.setY(Board.HEIGHT - 30);
        return vehicle;
    }

    public Vehicle enemy() {
        var enemy = new Vehicle();
        enemy.setX(Board.WIDTH / 2);
        enemy.setY(10);
        return enemy;
    }

}
