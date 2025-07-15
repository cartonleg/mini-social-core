package com.example.demo.services;

import com.example.demo.DTO.UserLoginDTO;
import com.example.demo.DTO.UserRegistrationDTO;
import com.example.demo.config.SecurityConfig;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserDoesNotExistException;
import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users registerUser(UserRegistrationDTO requestDTO) {
        Users existingUser = usersRepository.findByEmailOrUsername(requestDTO.getEmail(), requestDTO.getUsername()).orElse(null);
        if (existingUser != null){
            throw new UserAlreadyExistException("Email or username already in use.");
        }
        Users user = new Users();
        user.setEmail(requestDTO.getEmail());
        String encoded = passwordEncoder.encode(requestDTO.getPassword());
        user.setPassword(encoded);
        user.setUsername(requestDTO.getUsername());
        return usersRepository.save(user);
    }

    public Users loginUser(UserLoginDTO requestDTO) {
        Users user = usersRepository.findByEmailOrUsername(requestDTO.getEmailOrUsername(), requestDTO.getEmailOrUsername()).orElse(null);
        if ((user != null) && (passwordEncoder.matches(requestDTO.getPassword(), user.getPassword()))) {
            return user;
        }
        throw new UserDoesNotExistException("Incorrect credentials.");
    }

}
