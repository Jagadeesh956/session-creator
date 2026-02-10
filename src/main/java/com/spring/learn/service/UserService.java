package com.spring.learn.service;

import com.spring.learn.userdao.User;
import com.spring.learn.userdao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
   @Autowired
    UserRepository userRepository;

    public User addUser(){
     long Id =  userRepository.saveUser(System.currentTimeMillis());
       return new User(Id);
    }
}
