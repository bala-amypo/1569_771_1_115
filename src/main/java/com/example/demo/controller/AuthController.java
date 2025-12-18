package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService userService;
   
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        if (userService.findByEmail(user.getEmail()) != null) {

            return ResponseEntity.status(400).body("Email is already in use");
        } else {
            userService.registerUser(user);
            return ResponseEntity.status(201).body("User registered successfully");
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginUser) {
        User foundUser = userService.findByEmail(loginUser.getEmail());

        if (foundUser != null && loginUser.getPassword().equals(foundUser.getPassword())) {
            return ResponseEntity.status(200).body("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
