package org.kd.nileride.model;

import org.kd.nileride.config.GameConfig;
import org.kd.nileride.view.Drawer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;

import java.util.logging.Level;
import java.util.logging.Logger;

@Import(GameConfig.class)
public class Game extends Thread {

    private static final int GAME_FRAME_MS = 150;
    public Board board;
    public Drawer drawer;
    private boolean gameRunning = true;

    @Autowired
    @Qualifier("crash")
    private String crashMessage;

    @Override
    public void run() {
        while (gameRunning) {
            try {
                Thread.sleep(GAME_FRAME_MS);
                board.move();
                drawer.draw(board);

                if (board.checkCollision()) {
                    System.out.println(this.crashMessage);
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
