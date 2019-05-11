package org.kd.spring.knights;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class KnightMain {
    public static void main(String[] args) {

        //ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("org/kd/knights.xml");
        //FileSystemXmlApplicationContext context= new FileSystemXmlApplicationContext("C:\\Users\\kdrzazga\\Documents\\programming\\springxmlinjection\\src\\main\\resources\\org\\kd\\knights.xml");
        var context = new AnnotationConfigApplicationContext(KnightConfig.class);
        var knight = context.getBean("knight", Knight.class);
        knight.embarkOnQuest();

        List<Knight> knights = context.getBean(List.class);
        knights.forEach(warrior -> System.out.println(warrior.getClass()));
        context.close();
    }
}
