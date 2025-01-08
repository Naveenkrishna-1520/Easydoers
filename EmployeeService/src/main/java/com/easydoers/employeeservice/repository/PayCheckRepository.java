package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.easydoers.employeeservice.entity.PayCheck;


@Repository
public interface PayCheckRepository extends JpaRepository<PayCheck, Long>{

}
