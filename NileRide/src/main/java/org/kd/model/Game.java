package org.kd.model;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends Thread {

    private static final int GAME_FRAME_MS = 250;
    public Board board;

    public Game() {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(GAME_FRAME_MS);
                board.drawAllVehicles();

            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
