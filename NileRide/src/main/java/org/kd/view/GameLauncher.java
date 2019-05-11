package org.kd.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kd.config.GameConfig;
import org.kd.model.Game;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GameLauncher extends Application {

    @Value("appName:Nile Ride")
    private String appName;

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
        primaryStage.setTitle(appName);
        primaryStage.setScene(springContext.getBean(Scene.class));
        primaryStage.setOnCloseRequest(event -> exit());
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.show();

        var game = springContext.getBean(Game.class);
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
