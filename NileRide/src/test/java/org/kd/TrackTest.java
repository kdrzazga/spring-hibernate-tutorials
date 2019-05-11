package org.kd;

import org.junit.Test;
import org.kd.config.GameConfig;
import org.kd.model.Track;

import static org.junit.Assert.assertEquals;

public class TrackTest {

    @Test
    public void testShiftBanksLeft() {

        var track = new Track();
        assertEquals("Please adapt test to new data.", Integer.valueOf(40), track.getLeftBank().get(0));
        track.moveBanks(1);
        assertEquals(Integer.valueOf(41), track.getLeftBank().get(0));

    }

    @Test
    public void testShiftBanksRight() {

        var track = new Track();
        assertEquals("Please adapt test to new data.", Integer.valueOf(39), track.getLeftBank().get(1));
        track.moveBanks(-5);
        assertEquals(Integer.valueOf(34), track.getLeftBank().get(1));

    }

}
