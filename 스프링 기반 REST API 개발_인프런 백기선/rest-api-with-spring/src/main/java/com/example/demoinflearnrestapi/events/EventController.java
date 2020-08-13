package com.example.demoinflearnrestapi.events;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final EventValidator eventValidator;

    @PostMapping
    public ResponseEntity<Event> createEvent(@Valid @RequestBody EventDto eventDto) {

        eventValidator.validate(eventDto);
        Event event = modelMapper.map(eventDto, Event.class);
        final Event newEvent = eventRepository.save(event);
        final URI createUri = linkTo(EventController.class)
                .slash(newEvent.getId())
                .toUri();

        return ResponseEntity.created(createUri).body(event);
    }
}
