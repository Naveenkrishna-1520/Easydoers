package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.repository.UserRepository;
import com.easydoers.employeeservice.service.UserService;


@Service
public class UserServiceImplementation implements UserService{

	@Autowired
	private UserRepository userRepository;

	public Users findByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}

}
