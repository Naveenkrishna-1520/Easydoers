package com.easydoers.employeeservice.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByProductName(String productName);

	Product findByProductId(Long productId);

	
}
