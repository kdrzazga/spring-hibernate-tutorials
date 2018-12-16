package org.kd.stereo;

import org.springframework.stereotype.Component;

//@Component  //Exception: expected single matching bean but found 2: masterOfPuppetsCD,rootsCD
public class RootsCD implements CompactDisc {
    @Override
    public void play() {
        System.out.println("Roots, bloody roots! Roots, bloody roots!");
    }

    @Override
    public String getTitle() {
        return "Roots";
    }

    @Override
    public String getArtist() {
        return "Sepultura";
    }
}
