package org.kd.nileride.config;

import org.kd.nileride.model.Board;
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
