package com.example.inflearnrestapidemo.events;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@Slf4j
@RequestMapping(value = "/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final EventValidator eventValidator;

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity createEvent(@Valid @RequestBody EventDto eventDto, Errors errors) {
        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        eventValidator.validate(eventDto, errors);

        if(errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Event event = modelMapper.map(eventDto, Event.class);
        final Event newEvent = this.eventRepository.save(event);
        final URI uri = linkTo(EventController.class).slash(newEvent.getId()).toUri();
        return ResponseEntity.created(uri).body(newEvent);
    }
}
