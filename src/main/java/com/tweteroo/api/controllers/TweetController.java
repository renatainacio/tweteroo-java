package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    final TweetService tweetService;

    TweetController(TweetService tweetService){
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<Object> postTweet(@RequestBody @Valid TweetDTO tweetDTO){
        Optional<Tweet> tweet = tweetService.postTweet(tweetDTO);
        if(!tweet.isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserId is not valid");
        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }

    @GetMapping
    public ResponseEntity<List<Tweet>> getTweets(){
        return ResponseEntity.status(HttpStatus.OK).body(tweetService.getTweets());
    }
}
