package com.easydoers.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.UpgradePhoneTransfer;

@Repository
public interface UpgradePhonesTranferRepostiory extends JpaRepository<UpgradePhoneTransfer, Long>{

	UpgradePhoneTransfer findByTransferId(Long transferId);

	List<UpgradePhoneTransfer> findByTransferedStore(Store store);

}
