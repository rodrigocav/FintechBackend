package com.API.backend.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.backend.dtos.user.UserRequest;
import com.API.backend.dtos.user.UserResponse;
import com.API.backend.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;
    
    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    public List<UserResponse> list() {
        return service.list();
    }
    
    @PostMapping
    public UserResponse create(@RequestBody UserRequest request){
        return service.create(request);
    }
}