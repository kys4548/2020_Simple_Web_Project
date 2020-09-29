package com.example.demo04messageconverter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({EventConverter.class, EventController.class})
class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("String과 Object사이의 변환")
    void getTest() throws Exception {
        mockMvc.perform(get("/event/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
}