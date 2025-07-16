package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;

public class PostResponseDTO {
    private String username;

    @NotBlank
    private String text;

    public String getUsername() { return this.username; }
    public String getText() { return this.text; }

    public void setUsername(String username) { this.username = username; }
    public void setText(String text) { this.text = text; }
}
