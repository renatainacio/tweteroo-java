package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.TweetDTO;
import com.tweteroo.api.models.Tweet;
import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {

    final TweetRepository tweetRepository;

    final UserRepository userRepository;

    TweetService(TweetRepository tweetRepository, UserRepository userRepository){
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public Optional<Tweet> postTweet(TweetDTO tweetDTO){
        Optional<User> user = userRepository.findById(tweetDTO.getUserId());

        if (!user.isPresent()){
            return Optional.empty();
        }

        Tweet tweet = new Tweet(tweetDTO, user.get());
        return Optional.of(tweetRepository.save(tweet));
    }

    public List<Tweet> getTweets(){
        return tweetRepository.findAll();
    }
}
