package com.easydoers.employeeservice.exception;

public class ClockedInException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ClockedInException(String message) {
		super(message);
	}

}
