package org.kd.spring.aspects.concert;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience2 {

    public void watchPerformance(ProceedingJoinPoint jp){
        try {
            System.out.println("1");
            System.out.println("2");

            jp.proceed();

            System.out.println("brawo");
        }catch (Throwable t){
            System.out.println("Oddajce kase za bilety!");
        }
    }
}
