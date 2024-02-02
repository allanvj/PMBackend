package com.example.PersonnelManagement.Exception;

public class InvalidIdException extends Exception{
	
	private String message;

	public InvalidIdException() {
		super();
		
	}
     
	public InvalidIdException(String message) {
		super(message);
		this.message = message;
		
	}

}
