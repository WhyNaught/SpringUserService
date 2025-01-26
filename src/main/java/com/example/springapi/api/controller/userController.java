package com.example.springapi.api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.springapi.service.*;
import com.example.springapi.api.model.*;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
}
