package org.kd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kd.nileride.model.Track;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackTest {

    private Track track;

    @BeforeEach
    public void setup() {
        this.track = new Track();
    }

    @Test
    public void testShiftBanksLeft() {
        assertEquals(/*"Please adapt test to new data.",*/ Integer.valueOf(40), track.getLeftBank().get(0));
        track.moveBanks(1);
        assertEquals(Integer.valueOf(41), track.getLeftBank().get(0));

    }

    @Test
    public void testShiftBanksRight() {
        assertEquals(/*"Please adapt test to new data.", */Integer.valueOf(39), track.getLeftBank().get(1));
        track.moveBanks(-5);
        assertEquals(Integer.valueOf(34), track.getLeftBank().get(1));

    }

}
