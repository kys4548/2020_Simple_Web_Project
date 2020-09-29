package com.example.demo02xmlhttprequest;

public class EventMessage {
    private int id;
    private String message;

    public EventMessage() {
    }

    public EventMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EventMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
