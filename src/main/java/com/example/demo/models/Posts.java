package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postid;

    @Column(nullable = false)
    private String text;

    @CreationTimestamp
    private LocalDateTime creationtime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Users users;

    @OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
    private List<PostReaction> postreaction = new ArrayList<>();

    public Long getPostid() { return postid; }
    public String getText() { return text; }
    public Users getUserid() { return users; }
    public LocalDateTime getCreationtime() { return creationtime; }

    public void setText(String text) { this.text = text; }
}
