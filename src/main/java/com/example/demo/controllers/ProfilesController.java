package com.example.demo.controllers;

import com.example.demo.DTO.ProfileMapper;
import com.example.demo.DTO.ProfileRequestDTO;
import com.example.demo.models.Profiles;
import com.example.demo.services.ProfilesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/profiles")
public class ProfilesController {
    private final ProfilesService profilesService;
    private final ProfileMapper profileMapper;

    @Autowired
    public ProfilesController(ProfilesService profilesService, ProfileMapper profileMapper){
        this.profilesService = profilesService;
        this.profileMapper = profileMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrEditProfile(@Valid @RequestBody ProfileRequestDTO requestDTO){
        Profiles profile = profilesService.createOrEditProfile(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(profileMapper.toResponseDTO(profile));
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
