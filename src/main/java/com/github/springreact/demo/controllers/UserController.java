package com.github.springreact.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.springreact.demo.models.LoginForm;
import com.github.springreact.demo.models.User;
import com.github.springreact.demo.services.KafkaService;

@RestController
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private KafkaService kafkaService;
	
	@PostMapping("/api/login")
	public String login(@RequestBody LoginForm loginForm) {
		return "login";
	}
	
	@PostMapping("/api/signup")
	public String signup(@RequestBody User user) {
		return "signup";
	}
}
