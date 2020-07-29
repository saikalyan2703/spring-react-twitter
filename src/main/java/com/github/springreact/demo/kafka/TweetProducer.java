package com.github.springreact.demo.kafka;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.springreact.demo.models.Tweet;

@Component
@Scope("prototype")
public class TweetProducer implements Runnable{
	
	Logger logger = LoggerFactory.getLogger(TweetProducer.class);
	
	private BlockingQueue<Tweet> queue;
	private boolean isRunning;
	
	public TweetProducer() {
		this.queue = new LinkedBlockingQueue<>();
		isRunning = true;
	}

	@Override
	public void run() {
		logger.info("Tweet Producer is running");
		while (isRunning) {
			Tweet tweet = null;
			try {
				tweet = queue.take();
			} catch (InterruptedException e) {
			}
			if (tweet != null) {
				System.out.println("Producing tweet " + tweet);
				// Add more code for producing tweet to Kafka topic
			}
		}
		logger.info("Tweet producer is stopping");
	}
	
	public void stopTweetProducer() {
		isRunning = false;
	}
	
	public void produceTweet(Tweet tweet) {
		queue.add(tweet);
	}
	
	public void produceTweets(List<Tweet> tweets) {
		queue.addAll(tweets);
	}

}
