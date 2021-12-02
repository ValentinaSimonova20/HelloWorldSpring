package com.example.helloworldspring.ch3.xml;

public class Singer2 {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Singer2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
