package com.easydoers.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.easydoers.employeeservice.dto.ProductDTO;
import com.easydoers.employeeservice.entity.StoreInventory;

@Repository
public interface InventoryRepository extends JpaRepository<StoreInventory, Long>{

	@Query("SELECT new com.easydoers.employeeservice.dto.ProductDTO(p.id,p.productName, si.quantity) " +
	           "FROM StoreInventory si " +
	           "JOIN si.product p " +
	           "WHERE si.store.id = :storeId")
	List<ProductDTO> findProductsByStoreId(@Param("storeId")Long storeId);

}
