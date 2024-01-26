package com.tweteroo.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.UserDTO;
import com.tweteroo.api.models.User;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

    final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping
    public ResponseEntity<Object> postUser(@RequestBody @Valid UserDTO userDto){
        Optional<User> user = userService.postUser(userDto);

        if(!user.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This username is already taken.");
        return ResponseEntity.status(201).body(user);
    }
}
