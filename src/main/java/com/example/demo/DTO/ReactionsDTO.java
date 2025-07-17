package com.example.demo.DTO;

import com.example.demo.enums.ReactionsEnums;
import com.example.demo.enums.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReactionsDTO {
    private Long userid;

    @NotNull(message = "Post ID can't be null.")
    private Long postid;

    @NotNull(message = "Reaction can't be null.")
    @ValidEnum(enumClass = ReactionsEnums.class, message = "Valid reactions: (HAPPY, SAD, LIKE, DISLIKE).")
    private ReactionsEnums reaction;

    public Long getUserid() { return this.userid; }
    public Long getPostid() { return this.postid; }
    public ReactionsEnums getReaction() { return this.reaction; }

    public void setUserid(Long userid) { this.userid = userid; }
    public void setPostid(Long postid) { this.postid = postid; }
    public void setReaction(ReactionsEnums reaction) { this.reaction = reaction; }
}
