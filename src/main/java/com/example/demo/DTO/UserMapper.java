package com.example.demo.DTO;

import com.example.demo.models.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public Users toUser(UserRegistrationRequestDTO requestDTO){
        Users user = new Users();
        user.setEmail(requestDTO.getEmail());
        user.setUsername(requestDTO.getUsername());
        user.setPassword(requestDTO.getPassword());
        return user;
    }

    public UserResponseDTO toResponseDTO(Users user){
        UserResponseDTO response = new UserResponseDTO();
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        return response;
    }
}
