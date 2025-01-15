package com.easydoers.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.dto.LogInResponse;
import com.easydoers.employeeservice.service.LogInService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("v1/auth")
public class LogInServiceController {
	
	
	@Autowired
	private LogInService logInService;;
    
    
    @PostMapping("/login")
    public ResponseEntity<LogInResponse> login(@RequestBody LogInRequest logInRequest) {
    	LogInResponse response = logInService.loginUser(logInRequest);
		return ResponseEntity.ok()
                .header("Set-Cookie", response.getToken())
                .body(response);
    	
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(){
    	ResponseCookie cookie = ResponseCookie.from("jwt", null)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(0)
                .sameSite("Strict")
                .build();
        return ResponseEntity.ok()
                .header("Set-Cookie", cookie.toString())
                .body("Logged out successfully");
    	
    }

    
}
