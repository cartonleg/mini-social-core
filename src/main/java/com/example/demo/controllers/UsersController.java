package com.example.demo.controllers;

import com.example.demo.DTO.UserLoginRequestDTO;
import com.example.demo.DTO.UserMapper;
import com.example.demo.DTO.UserRegistrationRequestDTO;
import com.example.demo.DTO.UserResponseDTO;
import com.example.demo.models.Users;
import com.example.demo.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    private final UserMapper userMapper;

    @Autowired
    public UsersController(UsersService usersService, UserMapper userMapper) {
        this.usersService = usersService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationRequestDTO requestDTO) {
        UserResponseDTO response = usersService.registerUser(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginRequestDTO requestDTO) {
        UserResponseDTO response = usersService.loginUser(requestDTO);
        return ResponseEntity.ok(response);
    }
}
