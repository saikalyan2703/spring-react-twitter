package com.github.springreact.demo.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ErrorMessage {
	private String errorMessage;

	public ErrorMessage(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorMessage [errorMessage=" + errorMessage + "]";
	}	
}
