package org.kd.knights;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightMain {
    public static void main(String[] args) {

        //ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("org/kd/knights.xml");
        //FileSystemXmlApplicationContext context= new FileSystemXmlApplicationContext("C:\\Users\\kdrzazga\\Documents\\programming\\springxmlinjection\\src\\main\\resources\\org\\kd\\knights.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = context.getBean("knight", Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
