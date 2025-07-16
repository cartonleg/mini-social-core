package com.example.demo.services;

import com.example.demo.DTO.UserLoginRequestDTO;
import com.example.demo.DTO.UserMapper;
import com.example.demo.DTO.UserRegistrationRequestDTO;
import com.example.demo.DTO.UserResponseDTO;
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
    private final UserMapper userMapper;

    @Autowired
    public UsersService(UsersRepository usersRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public UserResponseDTO registerUser(UserRegistrationRequestDTO requestDTO) {
        Users existingUser = usersRepository.findByEmailOrUsername(requestDTO.getEmail(), requestDTO.getUsername()).orElse(null);
        if (existingUser != null){
            throw new AlreadyExistException("Email or username already in use.");
        }
        requestDTO.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        Users user = userMapper.toUser(requestDTO);
        usersRepository.save(user);
        return userMapper.toResponseDTO(user);
    }

    public UserResponseDTO loginUser(UserLoginRequestDTO requestDTO) {
        Users user = usersRepository.findByEmailOrUsername(requestDTO.getEmailOrUsername(), requestDTO.getEmailOrUsername()).orElse(null);
        if ((user != null) && (passwordEncoder.matches(requestDTO.getPassword(), user.getPassword()))) {
            return userMapper.toResponseDTO(user);
        }
        throw new DoesNotExistException("Incorrect credentials.");
    }

}
