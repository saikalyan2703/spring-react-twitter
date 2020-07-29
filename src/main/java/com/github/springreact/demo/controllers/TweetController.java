package com.github.springreact.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.github.springreact.demo.services.KafkaService;

@RestController
public class TweetController {
	
	Logger logger = LoggerFactory.getLogger(TweetController.class);
	
	@Autowired
	private KafkaService kafkaService;

}
