package com.easydoers.employeeservice.exception;

public class SavingEmployeeWorkException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public SavingEmployeeWorkException(String message) {
        super(message); // Pass the custom message to the parent class
    }

}
