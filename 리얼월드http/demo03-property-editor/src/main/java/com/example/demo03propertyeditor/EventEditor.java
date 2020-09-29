package com.example.demo03propertyeditor;

import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class EventEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }

    @Override
    public String getAsText() {
        Event event = (Event)getValue();
        return event.getId().toString();
    }
}
