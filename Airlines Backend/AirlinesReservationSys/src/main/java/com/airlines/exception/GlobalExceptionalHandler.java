package com.airlines.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.airlines.model.ErrorResponse;




@RestControllerAdvice
public class GlobalExceptionalHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(UserNotFoundException e) {
		ErrorResponse response=new ErrorResponse(new Date(),HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase(),"User not found with username and password");
		return new ResponseEntity<ErrorResponse>(response,HttpStatus.BAD_REQUEST);
	}
}
