package org.kd.spring.stereo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FollowTheLeaderCD implements CompactDisc {
    @Override
    public void play() {
        System.out.println("Feeling like a freak on a leash. Feeling like I have no relief...");
    }

    @Override
    public String getTitle() {
        return "Freak on a leash";
    }

    @Override
    public String getArtist() {
        return "Korn";
    }
}
