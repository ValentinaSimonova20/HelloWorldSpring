package com.example.helloworldspring.ch3.annotated;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service("injectCollection")
public class CollectionInjection {

    //@Resource(name = "map")
    private Map<String, Object> map;

   // @Resource(name = "props")
    private Properties props;

   // @Resource(name = "set")
    private Set set;

    //@Resource(name = "list")
    private List list;

    public void displayInfo(){
        System.out.println("Map contents:\n");
        map.forEach((key, value) -> System.out.println("Key: " +
                key + " - Value: " + value));

        System.out.println("\nProperties contents:\n");
        props.forEach((key, value) -> System.out.println("Key: "+
                key +" - Value: "+value));
        System.out.println("\nSet contents:\n");
        set.forEach(obj -> System.out.println("Value: "+obj));
        System.out.println("\nList contents:\n");
        list.forEach(obj -> System.out.println("Value: "+obj));

    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        CollectionInjection instance = (CollectionInjection)
                ctx.getBean("injectCollection");
        instance.displayInfo();
        ctx.close();
    }
}
