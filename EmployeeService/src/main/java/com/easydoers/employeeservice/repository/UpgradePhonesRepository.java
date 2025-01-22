package com.easydoers.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.UpgradePhones;

@Repository
public interface UpgradePhonesRepository extends JpaRepository<UpgradePhones, Long>{

	UpgradePhones findByImei(String imei);

	List<UpgradePhones> findByStore(Store store);

}
