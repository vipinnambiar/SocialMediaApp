package com.vipin.SocialMediaApp.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResponseMessage {
	
	String message;
	LocalDateTime datetime;
	public ResponseMessage(String message) {
		super();
		this.message = message;
		this.datetime = LocalDateTime.now();
	}
	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getDatetime() {
		return datetime;
	}




	@Override
	public String toString() {
		return "ResponseMessage [message=" + message + ", datetime=" + datetime + "]";
	}
	
	
	

}
