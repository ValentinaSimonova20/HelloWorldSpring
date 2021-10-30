package com.example.helloworldspring.ch3;

/**
 * Интерфейс предоставляющий услуги поиска
 * зависимостей
 */
public interface Container {
    Object getDependency(String key);
}
