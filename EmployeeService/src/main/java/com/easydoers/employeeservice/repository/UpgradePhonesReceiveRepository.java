package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.UpgradePhoneReceive;

@Repository
public interface UpgradePhonesReceiveRepository extends JpaRepository<UpgradePhoneReceive, Long>{

}
