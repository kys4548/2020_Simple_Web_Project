package com.example.inflearnrestapidemo.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("aadfsdf")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        final Event event = new Event();
        assertThat(event).isNotNull();
    }
}