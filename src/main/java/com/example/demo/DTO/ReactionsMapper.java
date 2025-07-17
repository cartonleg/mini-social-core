package com.example.demo.DTO;

import com.example.demo.models.Posts;
import com.example.demo.models.Reactions;
import com.example.demo.models.Users;
import com.example.demo.repositories.PostsRepository;
import com.example.demo.repositories.UsersRepository;
import org.springframework.stereotype.Component;

@Component
public class ReactionsMapper {
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;

    public ReactionsMapper(UsersRepository usersRepository, PostsRepository postsRepository) {
        this.usersRepository = usersRepository;
        this.postsRepository = postsRepository;
    }

    public Reactions toReaction(ReactionsDTO requestDTO){
        Reactions reaction = new Reactions();
        reaction.setReaction(requestDTO.getReaction());
        Users user = usersRepository.findByUserid(requestDTO.getUserid()).orElse(null);
        reaction.setUserid(user);
        Posts post = postsRepository.findByPostid(requestDTO.getPostid()).orElse(null);
        reaction.setPostid(post);
        return reaction;
    }

    public ReactionsDTO toReactionDTO(Reactions reaction){
        ReactionsDTO response = new ReactionsDTO();
        response.setReaction(reaction.getReaction());
        response.setPostid(reaction.getPostid().getPostid());
        response.setPostid(reaction.getPostid().getPostid());
        return response;
    }
}
