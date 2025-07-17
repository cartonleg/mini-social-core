package com.example.demo.DTO;

import com.example.demo.enums.ReactionsEnums;
import jakarta.validation.constraints.NotNull;

public class ReactionsDTO {
    private Long userid;

    @NotNull(message = "Post ID can't be null.")
    private Long postid;

    @NotNull(message = "Reaction can't be null.")
    private ReactionsEnums reaction;

    public Long getUserid() { return this.userid; }
    public Long getPostid() { return this.postid; }
    public ReactionsEnums getReaction() { return this.reaction; }

    public void setUserid(Long userid) { this.userid = userid; }
    public void setPostid(Long postid) { this.postid = postid; }
    public void setReaction(ReactionsEnums reaction) { this.reaction = reaction; }
}
