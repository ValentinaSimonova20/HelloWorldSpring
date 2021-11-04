package com.example.helloworldspring.ch3;

public class Singleton {
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }

    private Singleton() {
        // этот конструктор без аргументов требуется для того,
        // чтобы разработчики не смогли получить экземпляр
        // данного класса непосредственно
    }
}
