package com.example.demo.services;

import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
}
