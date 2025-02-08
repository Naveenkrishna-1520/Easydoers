package com.easydoers.employeeservice.exception;

public class DuplicateCompanyFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DuplicateCompanyFoundException(String message) {
		super(message);
	}

}
