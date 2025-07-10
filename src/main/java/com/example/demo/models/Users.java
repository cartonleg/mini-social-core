package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(unique = true, nullable = false)
    @Email(message = "not a valid e-mail address")
    @NotBlank(message = "e-mail cannot be empty")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "password cannot be empty")
    private String password;

    @Column(unique = true)
    private String username;

    @CreationTimestamp
    private LocalDateTime creationtime;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Profiles profile;

    public Long getUserid() { return userid; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getUsername() { return username; }
    public LocalDateTime getCreationtime() { return creationtime; }

    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setUsername(String username) { this.username = username; }

}
