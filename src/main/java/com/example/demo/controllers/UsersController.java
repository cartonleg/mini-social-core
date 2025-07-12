package com.example.demo.controllers;

import com.example.demo.DTO.UserRegistrationDTO;
import com.example.demo.models.Users;
import com.example.demo.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<Users> registerUser(@Valid @RequestBody UserRegistrationDTO requestDTO) {
        Users user =usersService.registerUser(requestDTO);
        return ResponseEntity.ok(user);
    }
}
