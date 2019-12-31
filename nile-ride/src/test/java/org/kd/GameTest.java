package org.kd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.nileride.config.GameConfig;
import org.kd.nileride.config.TestGameConfig;
import org.kd.nileride.model.BoardKeyListener;
import org.kd.nileride.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@Import({GameConfig.class, TestGameConfig.class})
public class GameTest {

    @Autowired
    private Game game;

    @Autowired
    private BoardKeyListener keyListener;

    @Test
    @Disabled
    public void testBoardWithBanksShiftedLeft() {

        fail("Not finished yet");
        //game.board.setBoardKeyListener(keyListener);
        game.start();

        //var pressLeft = new KeyEvent(game.drawer.getGc(), null ,KeyCode.LEFT, "");
        try {
            //game.board.getBoardKeyListener().handle(KeyEvent);
            Thread.sleep(Game.getGameFrameMs());
            assertEquals(/*"Please adapt test to new data.", */Integer.valueOf(40), game.board.getTrack().getLeftBank().get(0));
            game.board.getTrack().moveBanks(1);
            assertEquals(Integer.valueOf(41), game.board.getTrack().getLeftBank().get(0));
        } catch (InterruptedException e) {

            fail(e.getMessage());
        }

    }
}
