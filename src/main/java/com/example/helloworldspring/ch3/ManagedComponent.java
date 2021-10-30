package com.example.helloworldspring.ch3;


/**
 * Механизм контекстного поиска приводится в действие
 * через реализацию в окмпоненте интерфейса
 */
public interface ManagedComponent {
    void performLookup(Container container);
}
