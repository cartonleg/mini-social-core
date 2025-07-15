package com.example.demo.DTO;

public class ProfileResponseDTO {
    private String displayname;

    private String bio;

    private String username;

    public String getDisplayname() { return this.displayname; }
    public String getBio() { return this.bio; }
    public String getUsername() { return this.username; }

    public void setDisplayname(String displayname) { this.displayname = displayname; }
    public void setBio(String bio) { this.bio = bio; }
    public void setUsername(String username) { this.username = username; }
}
