package com.vipin.SocialMediaApp.model;


import java.time.LocalDate;

public class ErrorDetail {
	
	LocalDate  timeStamp;
	String message;
	String detail;
	public ErrorDetail(LocalDate timeStamp, String message, String detail) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.detail = detail;
	}
	

	
	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "ErrorDetail [timeStamp=" + timeStamp + ", message=" + message + ", detail=" + detail + "]";
	}

	

}
