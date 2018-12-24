package org.kd.spring.aspects.concert;

public class ClownPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("HA! HA!");
    }
}
