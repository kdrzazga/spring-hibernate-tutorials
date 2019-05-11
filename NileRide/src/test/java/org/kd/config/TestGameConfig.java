package org.kd.config;

import org.kd.model.Board;
import org.kd.model.BoardKeyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.awt.event.KeyEvent;

@Import({GameConfig.class})
public class TestGameConfig {

    @Autowired
    Board board;

    @Bean
    public KeyEvent leftKeyPressed(){
        //var leftKeyPressing = new KeyEvent();
        //TODO
        return null;
    }
}
