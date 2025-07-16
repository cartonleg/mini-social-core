package com.example.demo.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegistrationRequestDTO {
    @Email(message = "Please enter a valid e-mail.")
    @NotBlank(message = "E-mail is required.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 8, message = "Password must be atleast 8 characters.")
    private String password;

    @NotBlank(message = "User name is required.")
    @Size(max = 20, message = "User name must be a maximum of 20 characters")
    private String username;

    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }
    public String getUsername() { return this.username; }

    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setUsername(String username) { this.username = username; }
}
