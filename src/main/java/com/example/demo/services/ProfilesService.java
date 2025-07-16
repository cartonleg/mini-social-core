package com.example.demo.services;

import com.example.demo.DTO.ProfileMapper;
import com.example.demo.DTO.ProfileRequestDTO;
import com.example.demo.DTO.ProfileResponseDTO;
import com.example.demo.exceptions.DoesNotExistException;
import com.example.demo.models.Profiles;
import com.example.demo.models.Users;
import com.example.demo.repositories.ProfilesRepository;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilesService {
    private final ProfilesRepository profilesRepository;
    private final UsersRepository usersRepository;
    private final ProfileMapper profileMapper;

    @Autowired
    public ProfilesService(ProfilesRepository profilesRepository, UsersRepository usersRepository, ProfileMapper profileMapper){
        this.profilesRepository = profilesRepository;
        this.usersRepository = usersRepository;
        this.profileMapper = profileMapper;
    }

    public ProfileResponseDTO createOrEditProfile(ProfileRequestDTO requestDTO){
        Users user = usersRepository.findByUserid(requestDTO.getUserid()).orElse(null);
        if (user == null){
            throw new DoesNotExistException("User does not exist.");
        }
        Profiles profile = profilesRepository.findByUsers_Userid(requestDTO.getUserid()).orElse(null);
        if (profile != null){
            profile.setBio(requestDTO.getBio());
            profile.setDisplayname(requestDTO.getDisplayname());
            profilesRepository.save(profile);
            return profileMapper.toResponseDTO(profile);
        }
        Profiles profile2 = profileMapper.toProfile(requestDTO);
        profilesRepository.save(profile2);
        return profileMapper.toResponseDTO(profile2);
    }

}
