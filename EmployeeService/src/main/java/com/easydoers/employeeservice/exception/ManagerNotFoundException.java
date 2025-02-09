package com.easydoers.employeeservice.exception;

public class ManagerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ManagerNotFoundException(String message) {
        super(message); // Pass the custom message to the parent class
    }

}
