package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
	Users findByUserName(String userName);

}
