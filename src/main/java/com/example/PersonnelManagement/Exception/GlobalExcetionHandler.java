package com.example.PersonnelManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcetionHandler {
	
	@ExceptionHandler(value = InvalidFormatException.class)
	public ResponseEntity<?> invalidFormatException(InvalidFormatException c){
		          return new ResponseEntity<Object>("Given Format is Invalid", HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value = InvalidIdException.class)
	public ResponseEntity<?> invalidIdException(InvalidIdException c){
		          return new ResponseEntity<Object>("ID is not valid", HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value = NoDetailsFoundException.class)
	public ResponseEntity<?> noDetailsFoundException(NoDetailsFoundException c){
		          return new ResponseEntity<Object>("List is empty", HttpStatus.NOT_FOUND);
		
	}
}
