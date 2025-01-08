package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.StoreTarget;

@Repository
public interface storeTargetRepository extends JpaRepository<StoreTarget, Integer>{

}
