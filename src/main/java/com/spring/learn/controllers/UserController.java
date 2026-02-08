package com.spring.learn.controllers;

import com.spring.learn.dao.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/createUser")
    public User createUser(){
        return new User(System.currentTimeMillis());

    }
}
