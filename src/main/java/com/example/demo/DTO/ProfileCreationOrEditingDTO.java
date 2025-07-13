package com.example.demo.DTO;

import jakarta.validation.constraints.Size;

public class ProfileCreationOrEditingDTO {
    @Size(max = 50, message = "Bio must me a maximum of 50 characters.")
    private String bio;

    @Size(max = 20, message = "Display name must be a maximum of 10 characters.")
    private String displayname;

    private Long userid;

    public String getBio() { return this.bio; }
    public String getDisplayname() { return this.displayname; }
    public Long getUserid() { return this.userid; }

    public void setBio(String bio) { this.bio = bio; }
    public void setDisplayname(String displayname) { this.displayname = displayname; }
}
