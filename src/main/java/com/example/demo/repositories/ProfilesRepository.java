package com.example.demo.repositories;

import com.example.demo.models.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfilesRepository extends JpaRepository<Profiles, Long> {
    Optional<Profiles> findByProfileid(Long profileid);
    Optional<Profiles> findByUsers_Userid(Long userid);
}
