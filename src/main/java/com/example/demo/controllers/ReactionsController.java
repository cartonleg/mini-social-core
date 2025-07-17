package com.example.demo.controllers;

import com.example.demo.services.ReactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactionsController {
    private ReactionsService reactionsService;

    @Autowired
    public ReactionsController(ReactionsService reactionsService){
        this.reactionsService = reactionsService;
    }
}
