package com.example.demoinflearnrestapi.events;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final EventValidator eventValidator;

    @PostMapping
    public ResponseEntity createEvent(@Valid @RequestBody EventDto eventDto, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }
        eventValidator.validate(eventDto, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors);
        }
        Event event = modelMapper.map(eventDto, Event.class);
        event.update();
        final Event newEvent = eventRepository.save(event);
        final WebMvcLinkBuilder selfLinkBuilder = linkTo(EventController.class)
                .slash(newEvent.getId());

        final URI createUri = selfLinkBuilder.toUri();

        List<Link> links = Arrays.asList(
                selfLinkBuilder.withSelfRel(),
                selfLinkBuilder.withRel("update-event"),
                linkTo(EventController.class).withRel("query-events")
        );

        EntityModel model = EntityModel.of(event, links);


        return ResponseEntity.created(createUri).body(model);
    }
}
