package com.example.helloworldspring.ch2.annotated;

import com.example.helloworldspring.ch2.decoupled.HelloWorldMessageProvider;
import com.example.helloworldspring.ch2.decoupled.MessageProvider;
import com.example.helloworldspring.ch2.decoupled.MessageRenderer;
import com.example.helloworldspring.ch2.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HelloWorldConfiguration {

    // равнозначно разметке <bean id="provider" class=".."/>
    @Bean
    public MessageProvider provider(){
        return new HelloWorldMessageProvider();
    }

    // равнозначно разметке <bean id="renderer" class=".."/>
    @Bean
    public MessageRenderer renderer(){
        MessageRenderer renderer =
                new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}
