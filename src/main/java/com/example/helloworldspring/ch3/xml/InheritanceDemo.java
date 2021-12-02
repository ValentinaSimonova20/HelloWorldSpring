package com.example.helloworldspring.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InheritanceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        Singer2 parent = (Singer2) ctx.getBean("parent");
        Singer2 child = (Singer2) ctx.getBean("child");
        System.out.println("Parent:\n" + parent);
        System.out.println("Child:\n" + child);
    }
}
