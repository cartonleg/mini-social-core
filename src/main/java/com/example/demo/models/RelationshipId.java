package com.example.demo.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RelationshipId implements Serializable {
    private Long senderid;
    private Long receiverid;

    protected RelationshipId() {}
    public RelationshipId(Long senderid, Long receiverid) {
        this.senderid = senderid;
        this.receiverid = receiverid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelationshipId)) return false;
        RelationshipId that = (RelationshipId) o;
        return Objects.equals(senderid, that.senderid) && Objects.equals(receiverid, that.receiverid);
    }
    @Override
    public int hashCode() {
        return Objects.hash(senderid, receiverid);
    }

}
