package com.example.demo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class PostReaction {
    @EmbeddedId
    private ReactionId reactionid;

    @MapsId("userid")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Users users;

    @MapsId("postid")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postid", referencedColumnName = "postid")
    private Posts posts;

    @Column(nullable = false)
    private String reaction;

    @CreationTimestamp
    private LocalDateTime reactiontime;

    public Users getUserid() { return this.users; }
    public Posts getPostid() { return this.posts; }
    public String getReaction() { return this.reaction; }
    public LocalDateTime getReactiontime() { return this.reactiontime; }

    public void setReaction(String reaction) { this.reaction = reaction; }
}
