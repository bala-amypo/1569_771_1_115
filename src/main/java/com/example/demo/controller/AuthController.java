package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.registerUser(user);
    }
}
