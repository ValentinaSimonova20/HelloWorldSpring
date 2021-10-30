package com.example.helloworldspring.ch2.decoupled;

/**
 * Логика воспроизведения сообщения
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
