package com.example.springboot02;

public class MyEvent {
    private int data;
    private Object resource;

    public MyEvent(int data, Object resource) {
        this.data = data;
        this.resource = resource;
    }

    public int getData() {
        return data;
    }

    public Object getResource() {
        return resource;
    }
}
