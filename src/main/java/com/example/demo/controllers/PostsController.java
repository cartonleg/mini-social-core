package com.example.demo.controllers;

import com.example.demo.DTO.PostRequestDTO;
import com.example.demo.DTO.PostResponseDTO;
import com.example.demo.models.Posts;
import com.example.demo.services.PostsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostsController {
    private final PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService){
        this.postsService = postsService;
    }

    @PostMapping("/create/{id}")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostRequestDTO requestDTO, @PathVariable Long id){
        PostResponseDTO response = postsService.CreatePost(requestDTO, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
