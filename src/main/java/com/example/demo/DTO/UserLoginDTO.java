package com.example.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserLoginDTO {
    @NotBlank(message = "E-mail or username is required.")
    private String emailOrUsername;

    @NotBlank
    private String password;

    public String getEmailOrUsername() { return this.emailOrUsername; }
    public String getPassword() { return this.password; }

    public void setEmailOrUsername(String emailOrUsername) { this.emailOrUsername = emailOrUsername; }
    public void setPassword(String password) { this.password = password; }
}
