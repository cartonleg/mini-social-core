package com.example.demo.repositories;

import com.example.demo.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    Optional<Posts> findByPostid(Long postid);
    Optional<Posts> findByUsers_Userid(Long userid);
}
