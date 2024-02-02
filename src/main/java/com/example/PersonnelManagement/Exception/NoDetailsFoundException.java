package com.example.PersonnelManagement.Exception;

public class NoDetailsFoundException extends Exception{
	
	private String message;

	public NoDetailsFoundException() {
		super();
		
	}
     
	public NoDetailsFoundException(String message) {
		super(message);
		this.message = message;
		
	}

}
