package com.example.demo.repositories;

import com.example.demo.models.ReactionId;
import com.example.demo.models.Reactions;
import com.example.demo.services.ReactionsService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReactionsRepository extends JpaRepository<Reactions, ReactionId> {
    Optional<Reactions> findByUsers_Userid(Long userid);
    Optional<Reactions> findByPosts_Postid(Long postid);
}
