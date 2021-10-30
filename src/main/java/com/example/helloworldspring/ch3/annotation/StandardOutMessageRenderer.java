package com.example.helloworldspring.ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Реализация средства воспроизведения
// сложный служебный компонент Spring Bean
@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null){
            throw  new RuntimeException("You must set the "+
                    "property messageProvider of class:"+
                    StandardOutMessageRenderer.class.getName());
            // Установите свойство messageProvider в данном классе
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    @Autowired
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
