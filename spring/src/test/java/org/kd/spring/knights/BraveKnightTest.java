package org.kd.spring.knights;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest(){
        var mockQuest = mock(Quest.class); //pozona(mockowa) implementacja 1 obiektu classy Quest

        var knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();

        verify(mockQuest).embark();
    }
}
