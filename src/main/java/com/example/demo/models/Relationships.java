package com.example.demo.models;

import com.example.demo.enums.RelationshipsEnums;
import jakarta.persistence.*;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Relationships {
    @EmbeddedId
    private RelationshipId relationshipid;

    @MapsId("senderid")
    @ManyToOne
    @JoinColumn(name = "senderid", referencedColumnName = "userid")
    private Users sender;

    @MapsId("receiverid")
    @ManyToOne
    @JoinColumn(name = "receiverid", referencedColumnName = "userid")
    private Users receiver;

    @Column(nullable = false)
    private RelationshipsEnums status;

    @CreationTimestamp
    private LocalDateTime statustime;

    public Users getSenderid() { return this.sender; }
    public Users getReceiverid() { return this.receiver; }
    public RelationshipsEnums getStatus() { return this.status; }
    public LocalDateTime getStatustime() { return this.statustime; }

    public void setStatus(RelationshipsEnums status) { this.status = status; }
    public void setStatustime(LocalDateTime statustime) { this.statustime = statustime; }
    public void setReceiver(Users receiver) { this.receiver = receiver; }
    public void setSender(Users sender) { this.sender = sender; }
    public void setRelationshipid(RelationshipId relationshipid) { this.relationshipid = relationshipid; }
}
