package com.github.springreact.demo.services;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.springreact.demo.kafka.TweetProducer;
import com.github.springreact.demo.kafka.UserProducer;
import com.github.springreact.demo.models.Tweet;
import com.github.springreact.demo.models.User;

@Service
public class KafkaService {
	
	Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	@Autowired
	private UserProducer userProducer;
	
	@Autowired
	private TweetProducer tweetProducer;
	
	@PostConstruct
	private void postConstruct() {
		logger.info("Starting user producer thread");
		Thread userProducerThread = new Thread(userProducer);
		userProducerThread.start();
		
		logger.info("Starting tweet producer thread");
		Thread tweetProducerThread = new Thread(tweetProducer);
		tweetProducerThread.start();
	}
	
	public void produceUser(User user) {
		userProducer.produceUser(user);
	}
	
	public void produceTweet(Tweet tweet) {
		tweetProducer.produceTweet(tweet);
	}
}
