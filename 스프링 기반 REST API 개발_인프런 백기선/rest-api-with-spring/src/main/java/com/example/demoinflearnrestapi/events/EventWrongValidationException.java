package com.example.demoinflearnrestapi.events;

@Deprecated
public class EventWrongValidationException extends RuntimeException {

    EventWrongValidationException(String message) {
        super(message);
    }
}
