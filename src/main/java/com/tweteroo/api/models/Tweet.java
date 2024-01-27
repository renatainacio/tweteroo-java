package com.tweteroo.api.models;

import com.tweteroo.api.dtos.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false, length = 280)
    private String text;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Tweet(TweetDTO tweetDTO, User user){
        this.text = tweetDTO.getText();
        this.user = user;
    }

}
