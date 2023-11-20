package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    // @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //TODO edit for admin + hide passwords
    @GetMapping(value="/users")
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }
}
