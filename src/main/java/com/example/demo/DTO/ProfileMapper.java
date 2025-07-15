package com.example.demo.DTO;

import com.example.demo.models.Profiles;
import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {
    private final UsersRepository usersRepository;

    public ProfileMapper(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Profiles toProfile(ProfileRequestDTO requestDTO){
        Profiles profile = new Profiles();
        Users user = usersRepository.findByUserid(requestDTO.getUserid()).orElse(null);
        profile.setUserid(user);
        profile.setBio(requestDTO.getBio());
        profile.setDisplayname(requestDTO.getDisplayname());
        return profile;
    }

    public ProfileResponseDTO toResponseDTO(Profiles profile){
        ProfileResponseDTO response = new ProfileResponseDTO();
        response.setBio(profile.getBio());
        response.setDisplayname(profile.getDisplayname());
        response.setUsername(profile.getUserid().getUsername());
        return response;
    }
}
