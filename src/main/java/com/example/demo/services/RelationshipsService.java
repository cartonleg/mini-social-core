package com.example.demo.services;

import com.example.demo.DTO.RelationshipsDTO;
import com.example.demo.enums.RelationshipsEnums;
import com.example.demo.exceptions.AlreadyExistException;
import com.example.demo.exceptions.DoesNotExistException;
import com.example.demo.models.Profiles;
import com.example.demo.models.ReactionId;
import com.example.demo.models.RelationshipId;
import com.example.demo.models.Relationships;
import com.example.demo.repositories.ProfilesRepository;
import com.example.demo.repositories.RelationshipsRepository;
import com.example.demo.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipsService {
    private final ProfilesRepository profilesRepository;
    private final UsersRepository usersRepository;
    private final RelationshipsRepository relationshipsRepository;

    @Autowired
    public RelationshipsService(ProfilesRepository profilesRepository, UsersRepository usersRepository, RelationshipsRepository relationshipsRepository) {
        this.profilesRepository = profilesRepository;
        this.usersRepository = usersRepository;
        this.relationshipsRepository = relationshipsRepository;
    }

    public RelationshipsDTO sendFriendRequest(RelationshipsDTO requestDTO, Long id) {
        if (requestDTO.getReceiverId() == id) {
            // used this exception because it returns code confilict, might change later.
            throw new AlreadyExistException("Can't send friend request to self.");
        }
        Profiles profileSender = profilesRepository.findByUsers_Userid(id).orElse(null);
        if (profileSender == null) {
            throw new DoesNotExistException("Sender id does not exist.");
        }

        Profiles profileReceiver = profilesRepository.findByUsers_Userid(requestDTO.getReceiverId()).orElse(null);
        if (profileReceiver == null) {
            throw new DoesNotExistException("No user by this id.");
        }

        Relationships relationship = relationshipsRepository.findBySender_UseridAndReceiver_Userid(id, requestDTO.getReceiverId()).orElse(null);
        Relationships relationship2 = relationshipsRepository.findBySender_UseridAndReceiver_Userid(requestDTO.getReceiverId(), id).orElse(null);
        if (relationship == null && relationship2 == null) {
            relationship = new Relationships();
            relationship.setStatus(RelationshipsEnums.PENDING);
            relationship.setSender(usersRepository.findByUserid(id).orElse(null));
            relationship.setReceiver(usersRepository.findByUserid(requestDTO.getReceiverId()).orElse(null));
            RelationshipId relationshipId = new RelationshipId(id, requestDTO.getReceiverId());
            relationship.setRelationshipid(relationshipId);
            relationshipsRepository.save(relationship);
        }
        else if (relationship != null && relationship.getStatus() == RelationshipsEnums.PENDING) {
            throw new AlreadyExistException("You already sent a friend request, awaiting response.");
        }
        else if (relationship2 != null && relationship2.getStatus() == RelationshipsEnums.PENDING){
            throw new AlreadyExistException("You already have a pending request from this user, accept it to become friends");
        }
        else if ((relationship != null && relationship.getStatus() == RelationshipsEnums.FRIENDS) || (relationship2 != null && relationship2.getStatus() == RelationshipsEnums.FRIENDS)) {
            throw new AlreadyExistException("You are already friends.");
        }
        requestDTO.setStatus(RelationshipsEnums.PENDING);
        return requestDTO;
    }
}
