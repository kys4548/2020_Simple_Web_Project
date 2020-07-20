package com.example.springboot08.User;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/create")
    public User create(@RequestBody User user) {
        return user;
    }
}
