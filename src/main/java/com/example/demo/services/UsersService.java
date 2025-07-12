package com.example.demo.services;

import com.example.demo.DTO.UserLoginDTO;
import com.example.demo.DTO.UserRegistrationDTO;
import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users registerUser(UserRegistrationDTO requestDTO) {
        Users user = new Users();
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        user.setUsername(requestDTO.getUsername());
        return usersRepository.save(user);
    }

    public Users loginUser(UserLoginDTO requestDTO) {
        Users user = usersRepository.findByEmailOrUsername(requestDTO.getEmailOrUsername(), requestDTO.getEmailOrUsername()).orElse(null);
        if ((user != null) && (user.getPassword().equals(requestDTO.getPassword()))) {
            return user;
        }
        return null;
    }

}
