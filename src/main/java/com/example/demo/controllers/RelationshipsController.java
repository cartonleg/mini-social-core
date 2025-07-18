package com.example.demo.controllers;

import com.example.demo.DTO.RelationshipsDTO;
import com.example.demo.services.RelationshipsService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @GetMapping("/view/{id}")
    public Set<?> getReceivedRequests(@PathVariable Long id) {
        Set<?> list = relationshipsService.getRecievedRequests(id);
        return list;
    }
}
