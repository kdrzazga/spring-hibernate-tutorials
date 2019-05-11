package org.kd.model;

import org.kd.view.Drawer;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends Thread {

    private static final int GAME_FRAME_MS = 100;
    private static BigDecimal timer = BigDecimal.valueOf(0);
    public Board board;
    public Drawer drawer;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(GAME_FRAME_MS);
                timer.add(BigDecimal.ONE);
                //board.move();
                System.out.println(board.getTrack().getLeftBank().get(0));
                drawer.draw(board);

            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static int getGameFrameMs() {
        return GAME_FRAME_MS;
    }
}
