package com.example.demo.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ReactionId implements Serializable {
    private Long userid;

    private Long postid;

    protected ReactionId() {}
    public ReactionId(Long userid, Long postid) {
        this.userid = userid;
        this.postid = postid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReactionId)) return false;
        ReactionId that = (ReactionId) o;
        return Objects.equals(userid, that.userid) && Objects.equals(postid, that.postid);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userid, postid);
    }
}
