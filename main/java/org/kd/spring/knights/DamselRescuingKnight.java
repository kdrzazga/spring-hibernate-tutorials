package org.kd.spring.knights;

public class DamselRescuingKnight implements Knight{

    private final RescueDamselQuest quest;

    public DamselRescuingKnight(){
        this.quest = new RescueDamselQuest();//silne powiazanie
    }
    
    public void embarkOnQuest(){
        quest.embark();
    }
}
