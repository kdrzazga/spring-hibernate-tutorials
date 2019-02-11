package org.kd.spring.knights;

public class BraveKnight implements Knight{
    private Quest quest;

    public BraveKnight(Quest quest){ //wstrzykniecie dependecy - gotowego obiektu Quest
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
