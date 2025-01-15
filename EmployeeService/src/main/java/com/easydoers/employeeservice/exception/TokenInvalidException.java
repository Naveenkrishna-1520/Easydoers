package com.easydoers.employeeservice.exception;

public class TokenInvalidException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public TokenInvalidException(String message) {
        super(message); // Pass the custom message to the parent class
    }
}
