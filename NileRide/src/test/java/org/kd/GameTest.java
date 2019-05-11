package org.kd;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.config.GameConfig;
import org.kd.config.TestGameConfig;
import org.kd.model.BoardKeyListener;
import org.kd.model.Game;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.EventHandler;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Import({GameConfig.class, TestGameConfig.class})
public class GameTest {

    @Autowired
    private Game game;

    @Autowired
    private BoardKeyListener keyListener;

    @Test
    public void testBoardWithBanksShiftedLeft() {

        Assert.fail("Not finished yet");
        //game.board.setBoardKeyListener(keyListener);
        game.start();

        //var pressLeft = new KeyEvent(game.drawer.getGc(), null ,KeyCode.LEFT, "");
        try {
            //game.board.getBoardKeyListener().handle(KeyEvent);
            Thread.sleep(Game.getGameFrameMs());
            assertEquals("Please adapt test to new data.", Integer.valueOf(40), game.board.getTrack().getLeftBank().get(0));
            game.board.getTrack().moveBanks(1);
            assertEquals(Integer.valueOf(41), game.board.getTrack().getLeftBank().get(0));
        } catch (InterruptedException e) {

            Assert.fail(e.getMessage());

        }

    }
}
