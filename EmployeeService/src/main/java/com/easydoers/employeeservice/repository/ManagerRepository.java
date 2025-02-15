package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{

	Manager findByManagerNtid(String managerNtid);

	Manager findByManagerName(String managerName);

	Manager findByEmail(String userName);

}
