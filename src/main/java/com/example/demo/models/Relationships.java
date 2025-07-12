package com.example.demo.models;

import jakarta.persistence.*;
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
    private String status;

    @CreationTimestamp
    private LocalDateTime statustime;

    public Users getSenderid() { return this.sender; }
    public Users getReceiverid() { return this.receiver; }
    public String getStatus() { return this.status; }
    public LocalDateTime getStatustime() { return this.statustime; }

    public void setStatus(String status) { this.status = status; }
    public void setStatustime(LocalDateTime statustime) { this.statustime = statustime; }

}
