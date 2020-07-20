package com.example.springboot03;

public class MyEvent {
    private int data;
    private Object resoutce;

    public MyEvent(int data, Object resoutce) {
        this.data = data;
        this.resoutce = resoutce;
    }

    public int getData() {
        return data;
    }

    public Object getResoutce() {
        return resoutce;
    }
}
