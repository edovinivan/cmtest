package com.example.cmtest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @GetMapping(value = "/users")
    public String allUsers(){
        return "view all users";
    }
}
