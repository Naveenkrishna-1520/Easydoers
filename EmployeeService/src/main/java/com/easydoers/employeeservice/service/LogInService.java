package com.easydoers.employeeservice.service;

import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.dto.LogInResponse;

public interface LogInService {

	LogInResponse loginUser(LogInRequest logInRequest);


}
