package com.example.demo.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SitePing {
    @GetMapping("/ping")
    public String sitePing(){
        return "Hello world";
    }
}
