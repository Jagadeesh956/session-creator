package com.self.learn.springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeeting {

                    @GetMapping("/greeting")
    public String getMessage(){
                        return "Hello Session";
                    }
}
