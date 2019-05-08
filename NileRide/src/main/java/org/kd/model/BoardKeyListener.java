package org.kd.model;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class BoardKeyListener implements EventHandler<KeyEvent> {

    private Board board;

    public BoardKeyListener(Board board) {
        this.board = board;
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(event.getCode().getName());
        switch (event.getCode()) {
            case UP:
                board.mapPosition++;
                break;
            case DOWN:
                board.mapPosition--;
                System.out.println("down");
                break;
            case LEFT:
                board.getVehicle().x--;
                System.out.println("left");
                break;
            case RIGHT:
                board.getVehicle().x++;
                break;
        }
    }

}
