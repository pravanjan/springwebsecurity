package com.pravanjan.springwebsecurity.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @GetMapping("/getUserName")
    public String getUserName() {
        return "Hello User";
    }

    @GetMapping("/admin")
    public String adminMessage() {
        return "Hello Admin";
    }



}
