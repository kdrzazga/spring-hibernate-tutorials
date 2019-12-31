package org.kd.spring.stereo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kd.spring.stereo.media.CDPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void cdShouldBeOfKorn(){
        assertNotNull(cdPlayer);
        assertEquals("Korn", cdPlayer.getCd().getArtist());
    }
}
