package org.kd.spring.stereo;

import org.springframework.stereotype.Component;

@Component//ta klasa bedzie komponentem wewnatrz kontenera Springa
public class MasterOfPuppetsCD implements CompactDisc {

    private final static String title = "Battery";

    private final static String artist = "Metalika";

    @Override
    public void play() {
        System.out.println("Odtwarzam utwór " + title + " artysty " + artist);
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

}
