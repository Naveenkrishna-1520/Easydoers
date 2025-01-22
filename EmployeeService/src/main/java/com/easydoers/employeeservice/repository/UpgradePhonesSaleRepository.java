package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.UpgradePhonesSale;

@Repository
public interface UpgradePhonesSaleRepository extends JpaRepository<UpgradePhonesSale, Long>{

}
