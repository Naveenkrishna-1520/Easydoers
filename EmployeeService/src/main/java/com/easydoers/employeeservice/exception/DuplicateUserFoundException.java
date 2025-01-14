package com.easydoers.employeeservice.exception;

public class DuplicateUserFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DuplicateUserFoundException(String message) {
		super(message);
	}
}
