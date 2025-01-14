package com.easydoers.employeeservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.easydoers.employeeservice.dto.ErrorResponse;
import com.easydoers.employeeservice.exception.DuplicateUserFoundException;
import com.easydoers.employeeservice.exception.EmployeeNotFoundException;
import com.easydoers.employeeservice.exception.NoSalesFound;
import com.easydoers.employeeservice.exception.SavingEmployeeWorkException;
import com.easydoers.employeeservice.exception.StoreNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
	
	@ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStoreNotFoundException(StoreNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
	
	@ExceptionHandler(NoSalesFound.class)
    public ResponseEntity<ErrorResponse> handleNoSalesFound(NoSalesFound ex) {
        ErrorResponse response = new ErrorResponse(false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
	
	@ExceptionHandler(DuplicateUserFoundException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateUserFoundException(DuplicateUserFoundException ex) {
        ErrorResponse response = new ErrorResponse(false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
	
	@ExceptionHandler(SavingEmployeeWorkException.class)
    public ResponseEntity<ErrorResponse> handleSavingEmployeeWorkException(SavingEmployeeWorkException ex) {
        ErrorResponse response = new ErrorResponse(false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


}

