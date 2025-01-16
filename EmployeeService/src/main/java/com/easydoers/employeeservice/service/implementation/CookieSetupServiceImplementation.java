package com.easydoers.employeeservice.service.implementation;

import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.service.CookieSetupService;


@Service
public class CookieSetupServiceImplementation implements CookieSetupService{

	@Override
	public ResponseCookie setupJwtCookie(String jwtToken) {
		// Create an HttpOnly cookie
        ResponseCookie cookie = ResponseCookie.from("accessToken", jwtToken)
                .httpOnly(true)
                .secure(true) // Ensures the cookie is sent only over HTTPS
                .path("/")
                .maxAge(30 * 60) // 30 minutes
                .sameSite("Strict") // Prevents CSRF attacks
                .build();
		return cookie;
		
	}

	@Override
	public ResponseCookie setupRefreshJwtCookie(String refreshJwtToken) {
		// Set refresh token as an HttpOnly cookie
	    ResponseCookie refreshCookie = ResponseCookie.from("refreshToken", refreshJwtToken)
	            .httpOnly(true)
	            .secure(false) // Use true for HTTPS
	            .path("/")
	            .maxAge(7 * 24 * 60 * 60) // 7 days
	            .sameSite("Strict")
	            .build();
		return refreshCookie;
	}

}
