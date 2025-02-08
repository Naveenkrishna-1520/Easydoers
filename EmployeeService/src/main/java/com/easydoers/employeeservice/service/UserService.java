package com.easydoers.employeeservice.service;

import com.easydoers.employeeservice.entity.Users;

public interface UserService {
	
	Users findByUserName(String userName);

}
