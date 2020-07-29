package com.github.springreact.demo.models;

import java.sql.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Tweet {
	private String username;
	private String tweet;
	private Date timestamp;

	public Tweet(String username, String tweet, Date timestamp) {
		super();
		this.username = username;
		this.tweet = tweet;
		this.timestamp = timestamp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "Tweet [username=" + username + ", tweet=" + tweet + ", timestamp=" + timestamp + "]";
	}
}
