package com.easydoers.employeeservice.exception;

public class targetExistedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public targetExistedException(String message) {
        super(message); // Pass the custom message to the parent class
    }

}
