package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.entity.Product;
import com.easydoers.employeeservice.repository.ProductRepository;
import com.easydoers.employeeservice.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product checkProduct(String productName) {
		return productRepository.findByProductName(productName);
	}

	

}
