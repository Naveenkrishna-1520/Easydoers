package com.easydoers.employeeservice.exception;

public class payCheckGenerationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public payCheckGenerationException(String message) {
        super(message); // Pass the custom message to the parent class
    }

}
