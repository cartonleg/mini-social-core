package com.example.demo.repositories;

import com.example.demo.enums.RelationshipsEnums;
import com.example.demo.models.RelationshipId;
import com.example.demo.models.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface RelationshipsRepository extends JpaRepository<Relationships, RelationshipId> {
    Optional<Relationships> findBySender_UseridAndReceiver_Userid(Long senderid, Long receiverid);
    Optional<Relationships> findByReceiver_Userid(Long receiverid);
    Optional<Relationships> findBySender_Userid(Long senderid);

    @Query("SELECT r.sender.userid FROM Relationships r WHERE r.receiver.userid = :receiverid AND r.status = :status")
    Optional<Set<Long>> findSender_UseridByReceiver_Userid(Long receiverid, RelationshipsEnums status);
}
