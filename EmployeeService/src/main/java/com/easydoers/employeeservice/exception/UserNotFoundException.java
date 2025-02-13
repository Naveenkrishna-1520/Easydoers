package com.easydoers.employeeservice.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(String message) {
        super(message); // Pass the custom message to the parent class
    }

}
