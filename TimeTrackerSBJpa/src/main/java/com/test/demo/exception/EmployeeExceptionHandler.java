package com.test.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(UserNotFoundException exception)
	{
		ErrorResponse e=new ErrorResponse();
        e.setMessage(exception.getMessage());
		e.setCode("EMP-400");
        return new ResponseEntity(e,HttpStatus.BAD_REQUEST);
		
	}
	
}
