package com.easydoers.employeeservice.exception;

public class NoSalesFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NoSalesFound(String message) {
        super(message); // Pass the custom message to the parent class
    }

}
