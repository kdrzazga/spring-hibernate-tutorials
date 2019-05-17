package org.kd.nileride.config;

import org.kd.nileride.model.Board;
import org.kd.nileride.model.BoardKeyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.awt.event.KeyEvent;

@Import({GameConfig.class})
public class TestGameConfig {

    @Autowired
    Board board;

    @Bean
    BoardKeyListener boardKeyListener() {
        return new BoardKeyListener(board);
    }

    @Bean
    public KeyEvent leftKeyPressed(){
        //var leftKeyPressing = new KeyEvent();
        //TODO
        return null;
    }
}
