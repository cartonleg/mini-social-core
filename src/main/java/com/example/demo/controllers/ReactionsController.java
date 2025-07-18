package com.example.demo.controllers;

import com.example.demo.DTO.ReactionsDTO;
import com.example.demo.services.ReactionsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reactions")
public class ReactionsController {
    private ReactionsService reactionsService;

    @Autowired
    public ReactionsController(ReactionsService reactionsService){
        this.reactionsService = reactionsService;
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<?> reactToPost(@Valid @RequestBody ReactionsDTO requestDTO, @PathVariable Long id){
        ReactionsDTO response = reactionsService.reactToPost(requestDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
