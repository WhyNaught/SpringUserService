package com.example.springapi.api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.springapi.service.UserService;
import com.example.springapi.api.model.*;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class userController {

    private UserService UserService; 
    
    public userController(UserService UserService) {
        this.UserService = UserService; 
    }

    @GetMapping("/user/get")
    public User getUser(@RequestParam Integer id) {
        Optional<User> user = UserService.getUser(id); 
        if (user.isPresent()) {
            return (User) user.get(); 
        }
        return null; 
    }

    @PostMapping("/user/register")
    public String register(@RequestBody RegisterClass request) {
        return UserService.registerUser(request.getUsername(), request.getEmail(), request.getPassword()); 
    }
    
}
 