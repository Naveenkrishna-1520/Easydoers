package com.easydoers.employeeservice.exception;


public class EmployeeNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
        super(message); // Pass the custom message to the parent class
    }
}

