package org.kd.stereo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CdPlayerMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        CompactDisc cd = context.getBean(CompactDisc.class);
        cd.play();

        cd = context.getBean(MasterOfPuppetsCD.class);
        cd.play();
        context.close();
    }
}
