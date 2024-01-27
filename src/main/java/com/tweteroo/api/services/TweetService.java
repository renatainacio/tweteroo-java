package com.tweteroo.api.services;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.repositories.TweetRepository;

@Service
public class TweetService {

    final TweetRepository tweetRepository;

    TweetService(TweetRepository tweetRepository){
        this.tweetRepository = tweetRepository;
    }

    public Tweet postTweet(TweetDTO tweetDTO){

        Tweet tweet = new Tweet(tweetDTO);
        return tweetRepository.save(tweet);
    }
}
