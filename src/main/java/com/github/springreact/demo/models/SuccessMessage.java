package com.github.springreact.demo.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class SuccessMessage {
	private String message;

	public SuccessMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SuccessMessage [message=" + message + "]";
	}
}
