package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.easydoers.employeeservice.entity.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	 

}
