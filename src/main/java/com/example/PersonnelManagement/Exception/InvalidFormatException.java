package com.example.PersonnelManagement.Exception;

public class InvalidFormatException extends Exception{
	
	private String message;

	public InvalidFormatException() {
		super();
		
	}
     
	public InvalidFormatException(String message) {
		super(message);
		this.message = message;
		
	}

}
