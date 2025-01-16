package com.easydoers.employeeservice.service;

import org.springframework.http.ResponseCookie;

public interface CookieSetupService {

	ResponseCookie setupJwtCookie(String jwtToken);

	ResponseCookie setupRefreshJwtCookie(String refreshJwtToken);

}
