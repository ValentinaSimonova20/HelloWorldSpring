package com.example.helloworldspring.ch3.annotation;

import org.springframework.stereotype.Component;

/**
 * Реализация MessageProvider
 */
@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
