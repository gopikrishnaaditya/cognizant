package com.cognizant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cognizant.beans.ExceptionResponse;
import com.cognizant.exception.UserNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleException(UserNotFoundException ex){
		
		ExceptionResponse response = new ExceptionResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		
		return new ResponseEntity<ExceptionResponse>(response,HttpStatus.NOT_FOUND);
		
	}
	
}
