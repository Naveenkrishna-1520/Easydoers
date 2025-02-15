package com.easydoers.employeeservice.exception;

public class CompanyCredentialsNotMatchedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public CompanyCredentialsNotMatchedException(String message) {
        super(message); // Pass the custom message to the parent class
    }
}
