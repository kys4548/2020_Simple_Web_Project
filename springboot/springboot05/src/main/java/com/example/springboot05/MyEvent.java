package com.example.springboot05;

public class MyEvent {
    private String name;

    public MyEvent(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "name='" + name + '\'' +
                '}';
    }
}
