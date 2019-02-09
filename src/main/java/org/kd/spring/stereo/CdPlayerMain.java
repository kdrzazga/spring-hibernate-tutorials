package org.kd.spring.stereo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CdPlayerMain {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        var cd = context.getBean(CompactDisc.class);
        cd.play();

        cd = context.getBean(MasterOfPuppetsCD.class);
        cd.play();
        context.close();
    }
}
