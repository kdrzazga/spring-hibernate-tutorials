package org.kd.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kd.config.GameConfig;
import org.kd.model.Game;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GameLauncher extends Application {

    private AnnotationConfigApplicationContext springContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        springContext = new AnnotationConfigApplicationContext(GameConfig.class);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Anim");
        primaryStage.setScene(springContext.getBean(Scene.class));
        primaryStage.setOnCloseRequest(event -> exit());
        primaryStage.show();

        Game game = springContext.getBean(Game.class);
        game.start();
    }

    @Override
    public void stop() {
        springContext.stop();
    }

    private void exit(){
        System.exit(0);
    }
}
