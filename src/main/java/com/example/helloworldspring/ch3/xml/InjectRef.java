package com.example.helloworldspring.ch3.xml;

import com.example.helloworldspring.ch3.Oracle;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectRef {
    private Oracle oracle;

    public void setOracle(Oracle oracle){
        this.oracle = oracle;
    }

    public String toString(){
        return oracle.defineMeaningOfLife();
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        InjectRef injectRef = (InjectRef) ctx.getBean("injectRef");
        System.out.println(injectRef);
        ctx.close();
    }
}
