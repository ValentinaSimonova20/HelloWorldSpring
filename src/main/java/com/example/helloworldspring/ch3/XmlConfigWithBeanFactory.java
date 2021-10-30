package com.example.helloworldspring.ch3;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

// инициализация интерфейса BeanFactory и получение компонента oracle для обработки
public class XmlConfigWithBeanFactory {
    public static void main(String[] args) {
        // реализация BeanFactory
        DefaultListableBeanFactory factory =
                new DefaultListableBeanFactory();

        // данные типа BeanDefinition читаются из xml файла средствами
        // класса XmlBeanDefinitionReader
        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(new ClassPathResource
                ("spring/xml-bean-factory-config.xml"));
        Oracle oracle = (Oracle) factory.getBean("oracle");
        System.out.println(oracle.defineMeaningOfLife());
    }
}
