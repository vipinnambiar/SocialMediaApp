package com.vipin.SocialMediaApp.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vipin.SocialMediaApp.model.ErrorDetail;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public  final ResponseEntity<ErrorDetail> handleAllException(Exception ex, WebRequest request)
	{
		ErrorDetail errDet = new ErrorDetail(LocalDate.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetail>(errDet,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public  final ResponseEntity<ErrorDetail> handleUserNotFoundException(Exception ex, WebRequest request)
	{
		ErrorDetail errDet = new ErrorDetail(LocalDate.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ErrorDetail>(errDet,HttpStatus.BAD_REQUEST);
		
	}
}
