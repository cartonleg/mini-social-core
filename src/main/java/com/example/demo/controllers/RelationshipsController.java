package com.example.demo.controllers;

import com.example.demo.DTO.RelationshipsDTO;
import com.example.demo.services.RelationshipsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relationships")
public class RelationshipsController {
    private final RelationshipsService relationshipsService;

    public RelationshipsController(RelationshipsService relationshipsService) {
        this.relationshipsService = relationshipsService;
    }

    @PostMapping("/send/{id}")
    public RelationshipsDTO sendFriendRequest(@Valid @RequestBody RelationshipsDTO requestDTO, @PathVariable Long id) {
        RelationshipsDTO response = relationshipsService.sendFriendRequest(requestDTO, id);
        return response;
    }
}
