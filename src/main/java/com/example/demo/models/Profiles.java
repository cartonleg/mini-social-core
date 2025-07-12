package com.example.demo.models;

import jakarta.persistence.*;
import org.apache.catalina.User;

@Entity
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileid;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", unique = true)
    private Users users;

    private String displayname;

    private String bio;

    public Long getProfileid() { return profileid; }
    public Users getUserid() { return users; }
    public String getDisplayname() { return displayname; }
    public String getBio() { return bio; }

    public void setDisplayname(String displayname) { this.displayname = displayname; }
    public void setBio(String bio) { this.bio = bio; }

}
