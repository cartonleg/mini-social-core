package com.example.demo.services;

import com.example.demo.DTO.ProfileCreationOrEditingDTO;
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

    @Autowired
    public ProfilesService(ProfilesRepository profilesRepository, UsersRepository usersRepository){
        this.profilesRepository = profilesRepository;
        this.usersRepository = usersRepository;
    }

    public Profiles createOrEditProfile(ProfileCreationOrEditingDTO requestDTO){
        Users user = usersRepository.findByUserid(requestDTO.getUserid()).orElse(null);
        if (user == null){
            return null;
        }
        Profiles profile = profilesRepository.findByUsers_Userid(requestDTO.getUserid()).orElse(null);
        if (profile != null){
            profile.setBio(requestDTO.getBio());
            profile.setDisplayname(requestDTO.getDisplayname());
            return profilesRepository.save(profile);
        }
        Profiles profile2 = new Profiles();
        profile2.setUserid(user);
        profile2.setBio(requestDTO.getBio());
        profile2.setDisplayname(requestDTO.getDisplayname());
        return profilesRepository.save(profile2);
    }

}
