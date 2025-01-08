package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.entity.UserPrincipal;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.repository.UserRepository;

@Service
public class UserDeatilsServiceImplementation implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Users user = userRepository.findByUserName(userName);
		
		
		if (user == null) {
			
			throw new UsernameNotFoundException("User Not Found");
			
		}
		return new UserPrincipal(user);
	}

}
