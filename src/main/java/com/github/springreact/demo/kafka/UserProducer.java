package com.github.springreact.demo.kafka;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.springreact.demo.models.User;

@Component
@Scope("prototype")
public class UserProducer implements Runnable {
	
	Logger logger = LoggerFactory.getLogger(UserProducer.class);
	
	private BlockingQueue<User> queue;
	private boolean isRunning;
	
	public UserProducer() {
		this.queue = new LinkedBlockingQueue<>();
		isRunning = true;
	}

	@Override
	public void run() {
		logger.info("User Producer is running");
		while (isRunning) {
			User user = null;
			try {
				user = queue.take();
			} catch (InterruptedException e) {
			}
			if (user != null) {
				System.out.println("Producing user " + user);
				// Add more code for producing user to Kafka topic
			}
		}
		logger.info("User producer is stopping");
	}
	
	public void stopUserProducer() {
		isRunning = false;
	}
	
	public void produceUser(User user) {
		queue.add(user);
	}
	
	public void produceUsers(List<User> users) {
		queue.addAll(users);
	}

}
