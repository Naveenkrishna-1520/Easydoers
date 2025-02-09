package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Compensation;

@Repository
public interface CompensationRepository extends JpaRepository<Compensation, Long>{

}
