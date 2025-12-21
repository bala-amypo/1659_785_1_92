package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userservice;
    
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userservice.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = userservice.findByEmail(user.getEmail());

        if (existingUser == null) {
            return "User not found";
        }

        if (existingUser.getPassword().equals(user.getPassword())) {
            return "Login successful";
        }

        return "Invalid password";
    }
}
