package com.example.helloworldspring.ch2.decoupled;

/**
 * Реализация MessageProvider
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
