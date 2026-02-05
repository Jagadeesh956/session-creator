package com.self.learn.springbootapp.controllers;

import com.self.learn.springbootapp.dao.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/createUser")
    public User createUser(){
        return  new User();
    }
}
