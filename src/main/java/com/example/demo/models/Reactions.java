package com.example.demo.models;

import com.example.demo.enums.ReactionsEnums;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Reactions {
    @EmbeddedId
    private ReactionId reactionid;

    @MapsId("userid")
    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private Users userid;

    @MapsId("postid")
    @ManyToOne
    @JoinColumn(name = "postid", referencedColumnName = "postid")
    private Posts postid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReactionsEnums reaction;

    @CreationTimestamp
    private LocalDateTime reactiontime;

    public Users getUserid() { return this.userid; }
    public Posts getPostid() { return this.postid; }
    public ReactionsEnums getReaction() { return this.reaction; }
    public LocalDateTime getReactiontime() { return this.reactiontime; }

    public void setReaction(ReactionsEnums reaction) { this.reaction = reaction; }
    public void setPostid(Posts postid) { this.postid = postid; }
    public void setUserid(Users userid) { this.userid = userid; }
    public void setReactionid(ReactionId reactionid) {this.reactionid = reactionid; }
}
