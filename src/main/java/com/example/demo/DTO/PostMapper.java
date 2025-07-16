package com.example.demo.DTO;

import com.example.demo.models.Posts;
import com.example.demo.models.Users;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    private final UsersRepository usersRepository;

    @Autowired
    public PostMapper(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Posts toPost(PostRequestDTO requestDTO){
        Posts post = new Posts();
        Users user = usersRepository.findByUserid(requestDTO.getUserid()).orElse(null);
        post.setUserid(user);
        post.setText(requestDTO.getText());
        return post;
    }

    public PostResponseDTO toResponseDTO(Posts post){
        PostResponseDTO response = new PostResponseDTO();
        response.setText(post.getText());
        response.setUsername(post.getUserid().getUsername());
        return response;
    }
}
