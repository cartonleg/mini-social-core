package com.example.demo.repositories;

import com.example.demo.models.RelationshipId;
import com.example.demo.models.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RelationshipsRepository extends JpaRepository<Relationships, RelationshipId> {
    Optional<Relationships> findBySender_UseridAndReceiver_Userid(Long senderid, Long receiverid);
    Optional<Relationships> findByReceiver_Userid(Long receiverid);
    Optional<Relationships> findBySender_Userid(Long senderid);
}
