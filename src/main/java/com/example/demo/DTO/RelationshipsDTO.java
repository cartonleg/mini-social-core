package com.example.demo.DTO;

import com.example.demo.enums.RelationshipsEnums;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RelationshipsDTO {
    @NotNull(message = "Please specify who you want to send a friend request to by id.")
    private Long receiverId;

    @Enumerated(EnumType.STRING)
    private RelationshipsEnums status;

    public Long getReceiverId() { return this.receiverId; }
    public RelationshipsEnums getStatus() { return this.status; }

    public void setReceiverId(Long receiverUsername) { this.receiverId = receiverUsername; }
    public void setStatus(RelationshipsEnums status) { this.status = status; }
}
