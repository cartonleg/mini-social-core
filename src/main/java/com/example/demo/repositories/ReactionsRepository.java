package com.example.demo.repositories;

import com.example.demo.models.ReactionId;
import com.example.demo.models.Reactions;
import com.example.demo.services.ReactionsService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReactionsRepository extends JpaRepository<Reactions, ReactionId> {
    Optional<Reactions> findByUserid_Userid(Long userid);
    Optional<Reactions> findByPostid_Postid(Long postid);
}
