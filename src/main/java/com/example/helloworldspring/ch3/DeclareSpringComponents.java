package com.example.helloworldspring.ch3;

import com.example.helloworldspring.ch2.decoupled.MessageProvider;
import com.example.helloworldspring.ch3.annotation.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        MessageProvider messageProvider =
                ctx.getBean("provider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());
        ctx.close();
    }
}
