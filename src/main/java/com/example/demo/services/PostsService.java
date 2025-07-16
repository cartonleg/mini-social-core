package com.example.demo.services;

import com.example.demo.DTO.PostRequestDTO;
import com.example.demo.DTO.PostMapper;
import com.example.demo.DTO.PostResponseDTO;
import com.example.demo.exceptions.DoesNotExistException;
import com.example.demo.models.Posts;
import com.example.demo.models.Profiles;
import com.example.demo.models.Users;
import com.example.demo.repositories.PostsRepository;
import com.example.demo.repositories.ProfilesRepository;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;
    private final PostMapper postMapper;
    private final ProfilesRepository profilesRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository, UsersRepository usersRepository, PostMapper postMapper, ProfilesRepository profilesRepository){
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
        this.postMapper = postMapper;
        this.profilesRepository = profilesRepository;
    }

    public PostResponseDTO CreatePost(PostRequestDTO requestDTO){
        Profiles profile = profilesRepository.findByUsers_Userid(requestDTO.getUserid()).orElse(null);
        if (profile == null){
            throw new DoesNotExistException("Either user does not exist or user did not create a profile yet.");
        }
        Posts post = postMapper.toPost(requestDTO);
        postsRepository.save(post);
        return postMapper.toResponseDTO(post);
    }
}
