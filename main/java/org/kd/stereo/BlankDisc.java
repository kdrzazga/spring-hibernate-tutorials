package org.kd.stereo;

public class BlankDisc implements CompactDisc{

    private String title;
    private String artist;

    public BlankDisc(String title, String artist){
        this.artist = artist;
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Odtawrzam utwor " + title);
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String getArtist() {
        return "";
    }
}
