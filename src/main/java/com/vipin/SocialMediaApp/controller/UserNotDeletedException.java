package com.vipin.SocialMediaApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class UserNotDeletedException extends RuntimeException {

	
	   public UserNotDeletedException(String message) {
	        super(message);
	    }
}
