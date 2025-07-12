package com.example.demo.repositories;

import com.example.demo.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUserid(Long userid);
    Optional<Users> findByEmail(String email);
    Optional<Users> findByUsername(String username);
    Optional<Users> findByEmailOrUsername(String email, String username);

}
