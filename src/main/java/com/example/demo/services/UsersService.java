package com.example.demo.services;

import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.AlreadyExistException;
import com.example.demo.exceptions.DoesNotExistException;
import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users registerUser(UserDTO requestDTO) {
        Users existingUser = usersRepository.findByEmailOrUsername(requestDTO.getEmail(), requestDTO.getUsername()).orElse(null);
        if (existingUser != null){
            throw new AlreadyExistException("Email or username already in use.");
        }
        Users user = new Users();
        user.setEmail(requestDTO.getEmail());
        String encoded = passwordEncoder.encode(requestDTO.getPassword());
        user.setPassword(encoded);
        user.setUsername(requestDTO.getUsername());
        return usersRepository.save(user);
    }

    public Users loginUser(UserDTO requestDTO) {
        Users user = usersRepository.findByEmailOrUsername(requestDTO.getEmail(), requestDTO.getUsername()).orElse(null);
        if ((user != null) && (passwordEncoder.matches(requestDTO.getPassword(), user.getPassword()))) {
            return user;
        }
        throw new DoesNotExistException("Incorrect credentials.");
    }

}
