package com.easydoers.employeeservice.service.implementation;

import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.service.CookieSetupService;


@Service
public class CookieSetupServiceImplementation implements CookieSetupService{

	@Override
	public ResponseCookie setupJwtCookie(String jwtToken) {
		// Create an HttpOnly cookie
        ResponseCookie cookie = ResponseCookie.from("jwt", jwtToken)
                .httpOnly(true)
                .secure(true) // Ensures the cookie is sent only over HTTPS
                .path("/")
                .maxAge(30 * 60) // 30 minutes
                .sameSite("Strict") // Prevents CSRF attacks
                .build();
		return cookie;
		
	}

	

}
