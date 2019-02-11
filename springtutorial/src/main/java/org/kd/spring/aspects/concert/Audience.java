package org.kd.spring.aspects.concert;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {
    @Before("execution(** concert.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Widzowie wyciszają telefony komórkowe");
    }

    @Before("execution(** concert.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Widzowie zajmują miejsca");
    }

    @AfterReturning("execution(** concert.Performance.perform(..))")
    public void applause() {
        System.out.println("Brawooo! Oklaski!");
    }

    @AfterThrowing("execution(** concert.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Buu! Oddajcie pieniądze za bilety!");
    }
}
