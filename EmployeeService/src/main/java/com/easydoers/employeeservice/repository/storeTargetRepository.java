package com.easydoers.employeeservice.repository;

import java.time.YearMonth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreTarget;

@Repository
public interface StoreTargetRepository extends JpaRepository<StoreTarget, Integer>{

	StoreTarget findByStoreAndTargetMonth(Store store, YearMonth targetMonth);

	StoreTarget findByStoreAndTargetMonth(Store store, String targetMonth);

}
