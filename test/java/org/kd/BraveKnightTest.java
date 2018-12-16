package org.kd;


import org.junit.jupiter.api.Test;
import org.kd.knights.BraveKnight;
import org.kd.knights.Minstrel;
import org.kd.knights.Quest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class BraveKnightTest {

    @Test
    public void knightShouldEmbarkOnQuest(){
        Quest mockQuest = mock(Quest.class); //pozona(mockowa) implementacja 1 obiektu classy Quest


        BraveKnight knight = new BraveKnight(mockQuest);
        knight.embarkOnQuest();

        verify(mockQuest).embark();
    }
}
