package com.example.demo.services;

import com.example.demo.repositories.ReactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReactionsService {
    private ReactionsRepository reactionsRepository;

    @Autowired
    public ReactionsService(ReactionsRepository reactionsRepository){
        this.reactionsRepository = reactionsRepository;
    }

}
