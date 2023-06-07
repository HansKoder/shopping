package com.shopping.hansfullstack.shopping.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    @GetMapping("/hello-world")
    public String helloWorld () {
        return "Hello World, from Spring Boot";
    }

}
