package org.kd.spring.stereo;

import org.springframework.stereotype.Component;

@Component
public class StateOfMindReport implements CompactDisc{

    private final static String title = "Pizza Driver";

    private final static String artist = "Acid Drinkers";

    @Override
    public void play() {
        System.out.println("He left town a long time ago, and the dust chomped at him");
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
