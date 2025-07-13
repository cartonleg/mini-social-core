package com.example.demo.controllers;

import com.example.demo.DTO.UserLoginDTO;
import com.example.demo.DTO.UserRegistrationDTO;
import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRegistrationDTO requestDTO) {
        Users user = usersService.registerUser(requestDTO);
        if (user == null) {
            Map<String, String> error = Map.of("message", "Email or Username already in use.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody UserLoginDTO requestDTO) {
        Users user = usersService.loginUser(requestDTO);
        if (user == null){
            Map<String, String> error = Map.of("message", "Incorrect credintials.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        }
        return ResponseEntity.ok(user);
    }

    // this part is only used to return the errors from the DTO @Valid for the whole controller
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put("message", error.getDefaultMessage())
        );
        return errors;
    }
}
