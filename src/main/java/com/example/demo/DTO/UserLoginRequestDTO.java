package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;

public class UserLoginRequestDTO {
    @NotBlank(message = "E-mail or user name is required.")
    private String emailOrUsername;

    @NotBlank(message = "Password is required.")
    private String password;

    public String getEmailOrUsername() { return this.emailOrUsername; }
    public String getPassword() { return this.password; }

    public void setEmailOrUsername(String emailOrUsername) { this.emailOrUsername = emailOrUsername; }
    public void setPassword(String password) { this.password = password; }
}
