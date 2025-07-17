package com.example.demo.DTO;

import com.example.demo.enums.ReactionsEnums;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReactionsDTO {
    private Long userid;

    private Long postid;

    private ReactionsEnums reaction;

    public Long getUserid() { return this.userid; }
    public Long getPostid() { return this.postid; }
    public ReactionsEnums getReaction() { return this.reaction; }

    public void setUserid(Long userid) { this.userid = userid; }
    public void setPostid(Long postid) { this.postid = postid; }
    public void setReaction(ReactionsEnums reaction) { this.reaction = reaction; }
}
