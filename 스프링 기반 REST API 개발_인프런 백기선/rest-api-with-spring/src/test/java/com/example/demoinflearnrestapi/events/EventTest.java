package com.example.demoinflearnrestapi.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
        .name("Inflearn Spring REST API")
        .description("REST API development with Spring")
        .build();
        assertNotNull(event);
    }

    @Test
    public void javaBean() {
        Event event = new Event();
        final String name = "Event";
        event.setName(name);
        final String description = "Spring";
        event.setDescription(description);

        assertEquals(name, event.getName());
        assertEquals(description, event.getDescription());
    }
}