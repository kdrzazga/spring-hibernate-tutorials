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
        //System.out.println(event.getCode().getName());
        switch (event.getCode()) {
            case UP:
                board.getVehicle().accelerate();
                break;
            case DOWN:
                board.getVehicle().slowDown();
                //System.out.println("down");
                break;
            case LEFT:
                if (board.getTrack().moveBanks(-1))
                    System.out.println(
                            board.getTrack().getLeftBank().get(0));
                break;
            case RIGHT:
                //TODO
                if (board.getTrack().moveBanks(1))
                    ;//System.out.println("RIGHT");
                break;
        }
    }

}
