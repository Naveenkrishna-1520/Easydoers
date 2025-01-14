package com.easydoers.employeeservice.exception;

public class SignatureExceptionFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SignatureExceptionFound(String message) {
        super(message); // Pass the custom message to the parent class
        
    }

}
