package com.example.demo.services;

import com.example.demo.DTO.UsersRequestDTO;
import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users registerUser(UsersRequestDTO requestDTO) {
        Users user = new Users();
        user.setEmail(requestDTO.getEmail());
        user.setPassword(requestDTO.getPassword());
        user.setUsername(requestDTO.getUsername());
        return usersRepository.save(user);
    }

}
