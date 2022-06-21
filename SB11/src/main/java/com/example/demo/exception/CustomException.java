package com.example.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage> unaunthentication(Exception ex)
	{
		ErrorMessage er = new ErrorMessage(ex.getMessage());
		return new ResponseEntity<ErrorMessage>(er, new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
}
