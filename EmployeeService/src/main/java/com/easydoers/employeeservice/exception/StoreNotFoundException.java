package com.easydoers.employeeservice.exception;

public class StoreNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public StoreNotFoundException(String message) {
        super(message); // Pass the custom message to the parent class
    }

}
