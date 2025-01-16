package com.easydoers.employeeservice.service;

import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.dto.LogInResponse;
import com.easydoers.employeeservice.dto.RefreshTokenResponse;

public interface LogInService {

	LogInResponse loginUser(LogInRequest logInRequest);

	RefreshTokenResponse checkTokenRefresh(String refreshToken);


}
