package org.kd.spring.knights;

import java.io.PrintStream;

public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream){
        this.stream = stream;
    }

    public void singBeforeQuest(){
        stream.println("lalalala Dzielny rycerz");
    }

    public void singAfterQuest(){
        stream.println("Dzielny  rycer wypelnil questa");
    }
}
