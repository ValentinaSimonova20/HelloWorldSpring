package com.example.helloworldspring.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {

    private Map<String, Object> map;
    private Properties props;
    private Set set;
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

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public void setList(List list) {
        this.list = list;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx =
                new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        CollectionInjection instance = (CollectionInjection)
                ctx.getBean("injectCollection");
        instance.displayInfo();
        ctx.close();

    }
}
