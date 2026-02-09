package com.spring.learn.controllers;

import com.spring.learn.userdao.User;
import com.spring.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/createUser")
    public User createUser(){
       return userService.addUser();
    }
}
