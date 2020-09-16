package com.example.restfulwebservicereview.User;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public EntityModel<List<User>> findAll() {
        List<User> users = userService.findAll();

        EntityModel model = new EntityModel(users);
        Link self = linkTo(methodOn(this.getClass()).findAll()).withRel("self");
        model.add(self);

        return model;
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        if(user == null) {
            throw new UserNotFoundException(String.format("ID [%s] is not found", id));
        }

//        MappingJacksonValue mapping = new MappingJacksonValue(user);
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
//        FilterProvider filters = new SimpleFilterProvider().addFilter("User", filter);
//        mapping.setFilters(filters);


        EntityModel<User> model = new EntityModel(user);

        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(UserController.class).findById(id));
        Link link1 = linkBuilder.withRel("self");

        Link link2 = linkTo(methodOn(this.getClass()).findAll()).withRel("all-users");

        model.add(link1, link2);
        return model;
    }
}
