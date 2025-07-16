package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;

public class PostRequestDTO {
    private Long userid;

    @NotBlank(message = "Post text is required.")
    private String text;

    public Long getUserid() { return this.userid; }
    public String getText() { return this.text; }

    public void setUserid(Long userid) { this.userid = userid; }
    public void setText(String text) { this.text = text; }
}
