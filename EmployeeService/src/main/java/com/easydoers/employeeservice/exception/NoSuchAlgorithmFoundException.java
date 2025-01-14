package com.easydoers.employeeservice.exception;

public class NoSuchAlgorithmFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public NoSuchAlgorithmFoundException(String message) {
        super(message); // Pass the custom message to the parent class
    }
}
