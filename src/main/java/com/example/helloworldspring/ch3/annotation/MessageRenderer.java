package com.example.helloworldspring.ch3.annotation;

/**
 * Логика воспроизведения сообщения
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
