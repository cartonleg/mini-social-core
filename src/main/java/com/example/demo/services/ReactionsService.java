package com.example.demo.services;

import com.example.demo.DTO.ReactionsMapper;
import com.example.demo.DTO.ReactionsDTO;
import com.example.demo.exceptions.DoesNotExistException;
import com.example.demo.models.Posts;
import com.example.demo.models.Profiles;
import com.example.demo.models.Reactions;
import com.example.demo.models.Users;
import com.example.demo.repositories.PostsRepository;
import com.example.demo.repositories.ProfilesRepository;
import com.example.demo.repositories.ReactionsRepository;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionsService {
    private final ReactionsMapper reactionsMapper;
    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;
    private final ProfilesRepository profilesRepository;
    private ReactionsRepository reactionsRepository;

    @Autowired
    public ReactionsService(ReactionsRepository reactionsRepository, ReactionsMapper reactionsMapper, PostsRepository postsRepository, UsersRepository usersRepository, ProfilesRepository profilesRepository){
        this.reactionsRepository = reactionsRepository;
        this.reactionsMapper = reactionsMapper;
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
        this.profilesRepository = profilesRepository;
    }

    public ReactionsDTO reactToPost(ReactionsDTO requestDTO, Long id){
        requestDTO.setUserid(id);
        Posts post = postsRepository.findByPostid(requestDTO.getPostid()).orElse(null);
        Profiles profile = profilesRepository.findByUsers_Userid(requestDTO.getUserid()).orElse(null);
        Users user = usersRepository.findByUserid(requestDTO.getUserid()).orElse(null);
        if (post == null || profile == null){
            throw new DoesNotExistException("Either user or post does not exist, or the user trying to react didn't create a profile yet.");
        }
        Reactions reaction = reactionsMapper.toReaction(requestDTO);
        reactionsRepository.save(reaction);
        return reactionsMapper.toReactionDTO(reaction);
    }

}
