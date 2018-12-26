package org.kd.spring.aspects.concert;

import org.aspectj.lang.annotation.*;

@Aspect
public class AudienceWithPointcut {

    @Pointcut("execution(** concert.Performance.perform(..))")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Widzowie wyciszają telefony komórkowe");
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Widzowie zajmują miejsca");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("Brawooo! Oklaski!");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Buu! Oddajcie pieniądze za bilety!");
    }
}
