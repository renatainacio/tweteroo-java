package com.tweteroo.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Tweet> postTweet(@RequestBody @Valid TweetDTO tweetDTO){
        Tweet tweet = tweetService.postTweet(tweetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }
}
