package org.kd.spring.stereo.media;

import org.kd.spring.stereo.CompactDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
    }

    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }


    public CompactDisc getCd() {
        return cd;
    }
}
