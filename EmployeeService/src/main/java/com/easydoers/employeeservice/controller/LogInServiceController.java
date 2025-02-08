package com.easydoers.employeeservice.controller;


import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.dto.LogInResponse;
import com.easydoers.employeeservice.dto.RefreshTokenResponse;
import com.easydoers.employeeservice.service.LogInService;

@RestController
@RequestMapping("v1/auth")
public class LogInServiceController {
	
	
	@Autowired
	private LogInService logInService;
    
    
    @PostMapping("/login")
    public ResponseEntity<LogInResponse> login(@RequestBody LogInRequest logInRequest) {
    	LogInResponse response = logInService.loginUser(logInRequest);
		return ResponseEntity.ok()
                .header("Set-Cookie", response.getToken())
                .header("Set-Cookie", response.getRefreshToken())
                .header("Activity-Start", Instant.now().toString())
                .body(response);
    	
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(){
    	ResponseCookie cookie = ResponseCookie.from("accessToken", null)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(0)
                .sameSite("Strict")
                .build();
        ResponseCookie clearCookie = ResponseCookie.from("refreshToken", "")
                .httpOnly(true)
                .secure(false) 
                .path("/")
                .maxAge(0) 
                .sameSite("Strict")
                .build();
        return ResponseEntity.ok()
                .header("Set-Cookie", cookie.toString())
                .header("Set-Cookie", clearCookie.toString())
                .body("Logged out successfully");
    	
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<RefreshTokenResponse> refreshToken(@CookieValue("refreshToken") String refreshToken) {
    	RefreshTokenResponse response = logInService.checkTokenRefresh(refreshToken);
    	return ResponseEntity.ok()
                .header("Set-Cookie", response.getAccesstoken())
                .body(response);
        
    }
}
