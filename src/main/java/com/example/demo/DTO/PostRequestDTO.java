package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostRequestDTO {
    private Long userid;

    @NotBlank(message = "Post text is required.")
    @Size(min = 1, message = "Post text length can't be less than 1 character.")
    private String text;

    public Long getUserid() { return this.userid; }
    public String getText() { return this.text; }

    public void setUserid(Long userid) { this.userid = userid; }
    public void setText(String text) { this.text = text; }
}
