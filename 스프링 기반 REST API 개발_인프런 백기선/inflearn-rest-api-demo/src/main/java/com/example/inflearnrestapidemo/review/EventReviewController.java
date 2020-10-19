package com.example.inflearnrestapidemo.review;

import com.example.inflearnrestapidemo.events.Event;
import com.example.inflearnrestapidemo.events.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@Slf4j
@RequestMapping(value = "/api/eventsReview")
@RequiredArgsConstructor
public class EventReviewController {

    private final EventRepository eventRepository;
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity createEvent(@RequestBody Event event) {
        final Event savedEvent = eventRepository.save(event);
        final URI uri = linkTo(EventReviewController.class).slash(savedEvent.getId()).toUri();
        return ResponseEntity.created(uri).body(savedEvent);
    }
}
