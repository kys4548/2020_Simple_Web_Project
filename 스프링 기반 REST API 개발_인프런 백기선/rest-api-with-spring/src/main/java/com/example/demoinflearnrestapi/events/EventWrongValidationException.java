package com.example.demoinflearnrestapi.events;

public class EventWrongValidationException extends RuntimeException {

    EventWrongValidationException(String message) {
        super(message);
    }
}
