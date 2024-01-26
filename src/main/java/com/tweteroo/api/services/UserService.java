package com.tweteroo.api.services;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User postUser(UserDTO userDTO){
        User user = new User(userDTO);
        return userRepository.save((user));
    }

}
