package com.example.demoinflearnrestapi.events;

import com.example.demoinflearnrestapi.index.IndexController;
import lombok.RequiredArgsConstructor;
import org.jboss.jandex.Index;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/api/events", produces = MediaTypes.HAL_JSON_VALUE)
public class EventController {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final EventValidator eventValidator;

    @PutMapping("/{id}")
    public ResponseEntity updateEvent(@PathVariable("id") Long id,
                                      @RequestBody @Valid EventDto eventDto,
                                      Errors errors) {
        final Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if(errors.hasErrors()) {
            return badRequest(errors);
        }
        eventValidator.validate(eventDto, errors);
        if(errors.hasErrors()) {
            return badRequest(errors);
        }

        final Event existingEvent = optionalEvent.get();
        modelMapper.map(eventDto, existingEvent);
        final Event savedEvent = eventRepository.save(existingEvent);

        EntityModel model  = EntityModel.of(savedEvent);

        List<Link> links = Arrays.asList(
                linkTo(EventController.class).slash(savedEvent.getId()).withSelfRel(),
                linkTo(IndexController.class).slash("docs/index.html#resources-events-update").withRel("profile")
        );
        model.add(links);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEvent(@PathVariable("id") Long id) {
        final Optional<Event> optionalEvent = eventRepository.findById(id);
        if(optionalEvent.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        EntityModel model = EntityModel.of(optionalEvent.get());

        List<Link> links = Arrays.asList(
                linkTo(methodOn(EventController.class).getEvent(id)).withSelfRel(),
                linkTo(IndexController.class).slash("docs/index.html#resources-events-get").withRel("profile")
        );

        model.add(links);

        return ResponseEntity.ok(model);
    }

    @PostMapping
    public ResponseEntity createEvent(@Valid @RequestBody EventDto eventDto,
                                      Errors errors) {
        if (errors.hasErrors()) {
            return badRequest(errors);
        }
        eventValidator.validate(eventDto, errors);
        if (errors.hasErrors()) {
            return badRequest(errors);
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
                linkTo(EventController.class).withRel("query-events"),
                linkTo(IndexController.class).slash("/docs/index.html#resources-event-create").withRel("profile")
        );

        EntityModel model = EntityModel.of(event, links);


        return ResponseEntity.created(createUri).body(model);
    }

    @GetMapping
    public ResponseEntity queryEvents(Pageable pageable,
                                      PagedResourcesAssembler assembler,
                                      Principal principal) {
        final Page<Event> page = eventRepository.findAll(pageable);
        PagedModel model = assembler.toModel(page, e -> {
            return EntityModel.of(e).add(
                    linkTo(EventController.class).slash(((Event)e).getId()).withSelfRel()
            );
        });

        List<Link> links = new ArrayList(Arrays.asList(
                linkTo(IndexController.class).slash("/docs/index.html#resources-events-list").withRel("profile")
        ));
        if(principal != null) {
            links.add(linkTo(EventController.class).withRel("create-event"));
        }
        model.add(links);

        return ResponseEntity.ok(model);
    }

    private ResponseEntity<EntityModel<Errors>> badRequest(Errors errors) {
        return ResponseEntity.badRequest().body(EntityModel.of(errors).add(linkTo(methodOn(IndexController.class).index()).withRel("index")));
    }
}
