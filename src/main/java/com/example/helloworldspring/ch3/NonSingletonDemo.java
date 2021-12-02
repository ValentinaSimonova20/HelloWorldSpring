package com.example.helloworldspring.ch3;

import com.example.helloworldspring.ch3.annotated.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Map;

public class NonSingletonDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();

        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        Singer singer1 = ctx.getBean("nonSingleton", Singer.class);
        Singer singer2 = ctx.getBean("nonSingleton", Singer.class);

        System.out.println("Indentity Equal?: "+ (singer1 == singer2));
//        System.out.println("Value Equal:? " + singer1.getName().equals(singer2.getName()));
//        System.out.println(singer1.getName());
//        System.out.println(singer2.getName());
        ctx.close();


    }
}
