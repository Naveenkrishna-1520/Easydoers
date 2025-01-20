package com.easydoers.employeeservice.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.easydoers.employeeservice.dto.ErrorResponse;
import com.easydoers.employeeservice.exception.DuplicateUserFoundException;
import com.easydoers.employeeservice.exception.EmployeeNotFoundException;
import com.easydoers.employeeservice.exception.NoSalesFound;
import com.easydoers.employeeservice.exception.NoSuchAlgorithmFoundException;
import com.easydoers.employeeservice.exception.SavingEmployeeWorkException;
import com.easydoers.employeeservice.exception.SignatureExceptionFound;
import com.easydoers.employeeservice.exception.StoreNotFoundException;
import com.easydoers.employeeservice.exception.TokenInvalidException;
import com.easydoers.employeeservice.exception.payCheckGenerationException;

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
	@ExceptionHandler(NoSuchAlgorithmFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchAlgorithmFoundException(NoSuchAlgorithmFoundException ex) {
        ErrorResponse response = new ErrorResponse(false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
	
	@ExceptionHandler(SignatureExceptionFound.class)
    public ResponseEntity<ErrorResponse> handleSignatureExceptionFound(SignatureExceptionFound ex) {
        ErrorResponse response = new ErrorResponse(false, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
	
	@ExceptionHandler(TokenInvalidException.class)
	public ResponseEntity<Map<String, Object>> handleTokenInvalidException(TokenInvalidException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.UNAUTHORIZED.value());
        response.put("error", "Unauthorized");
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
	@ExceptionHandler(payCheckGenerationException.class)
	public ResponseEntity<Map<String, Object>> handlepayCheckGenerationException(payCheckGenerationException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}

