package org.kd.stereo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kd.stereo.media.CDPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cdPlayer);
        assertEquals("Metalika", cdPlayer.getCd().getArtist());
    }
}
