package com.pravanjan.springwebsecurity.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }

    @GetMapping("/getUserName")
    public String getUserName() {
        return "Hello User";
    }

    @GetMapping("/admin")
    public String adminMessage() {
        return "Hello Admin";
    }

}
