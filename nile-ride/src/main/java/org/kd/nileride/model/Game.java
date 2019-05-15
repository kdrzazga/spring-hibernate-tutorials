package org.kd.nileride.model;

import org.kd.nileride.view.Drawer;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends Thread {

    private static final int GAME_FRAME_MS = 150;
    private static BigDecimal timer = BigDecimal.valueOf(0);
    public Board board;
    public Drawer drawer;
    private boolean gameRunning = true;

    @Override
    public void run() {
        while (gameRunning) {
            try {
                Thread.sleep(GAME_FRAME_MS);
                timer.add(BigDecimal.ONE);
                board.move();
                //System.out.println(board.getTrack().getLeftBank().get(0));
                drawer.draw(board);

                if (board.checkCollision()) {
                    System.out.println("CRASH !");
                    gameRunning = false;
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void startGame() {
        this.gameRunning = true;
    }

    public void stopGame() {
        this.gameRunning = false;
    }

    public static int getGameFrameMs() {
        return GAME_FRAME_MS;
    }
}
