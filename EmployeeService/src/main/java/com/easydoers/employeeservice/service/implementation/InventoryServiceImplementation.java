package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.dto.AddMinimumInventoryRequest;
import com.easydoers.employeeservice.dto.DeleteProductRequest;
import com.easydoers.employeeservice.dto.ProductDTO;
import com.easydoers.employeeservice.dto.StoreInventoryDTO;
import com.easydoers.employeeservice.dto.UpdateInventoryRequest;
import com.easydoers.employeeservice.entity.Product;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreInventory;
import com.easydoers.employeeservice.repository.InventoryRepository;
import com.easydoers.employeeservice.repository.StoreInventoryRepository;
import com.easydoers.employeeservice.service.InventoryService;
import com.easydoers.employeeservice.service.ProductService;
import com.easydoers.employeeservice.service.StoreService;

@Service
public class InventoryServiceImplementation implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreInventoryRepository storeInventoryRepository;
	@Autowired
	private ProductService productService;

	@Override
	public StoreInventoryDTO getStoreInventory(String dealerStoreId) {
		Store store = storeService.checkStore(dealerStoreId);
		List<ProductDTO> products = inventoryRepository.findProductsByStoreId(store.getStoreId());
		return new StoreInventoryDTO(products);
	}

	@Override
	public Map<String, Object> addMinimumInventoryToStores(AddMinimumInventoryRequest inventoryRequest) {
		Store store = getStore(inventoryRequest.getDealerStoreId());
		for (ProductDTO product : inventoryRequest.getProducts()) {
			StoreInventory storeInventory = new StoreInventory();
			Product productInfo = getProduct(product);
			StoreInventory checkStoreInventory = getStoreAndProduct(store, productInfo);
			if (checkStoreInventory == null) {
				storeInventory.setStore(store);
				storeInventory.setProduct(productInfo);
				storeInventory.setMinimumQuantity(product.getQuantity());
				storeInventoryRepository.save(storeInventory);
			} else {
				checkStoreInventory.setMinimumQuantity(product.getQuantity());
				storeInventoryRepository.save(checkStoreInventory);
			}

		}
		Map<String, Object> response = new HashMap<>();
		response.put("timestamp : ", LocalDateTime.now());
		response.put("message : ", "adding minimum inventory requirement for store : "
				+ inventoryRequest.getDealerStoreId() + " is successfuly done");
		return response;
	}

	@Override
	public Map<String, Object> updateInventoryToStores(UpdateInventoryRequest inventoryRequest) {
		Store store = getStore(inventoryRequest.getDealerStoreId());
		for (ProductDTO product : inventoryRequest.getProducts()) {
			Product productInfo = getProduct(product);
			StoreInventory checkStoreInventory = getStoreAndProduct(store, productInfo);
			if (checkStoreInventory != null) {
				checkStoreInventory.setQuantity(product.getQuantity());
				storeInventoryRepository.save(checkStoreInventory);
			}
		}
		Map<String, Object> response = new HashMap<>();
		response.put("timestamp : ", LocalDateTime.now());
		response.put("message : ",
				"updating inventory for store : " + inventoryRequest.getDealerStoreId() + " is successfuly done");
		return response;
	}

	@Override
	public Map<String, Object> deleteInventoryfromStore(DeleteProductRequest deleteProductRequest) {
		Store store = getStore(deleteProductRequest.getDealerStoreId());
		Product productInfo = getProduct(deleteProductRequest.getProduct());
		StoreInventory checkStoreInventory = getStoreAndProduct(store, productInfo);
		storeInventoryRepository.delete(checkStoreInventory);
		Map<String, Object> response = new HashMap<>();
		response.put("timestamp : ", LocalDateTime.now());
		response.put("message : ", "deleted " + productInfo.getProductName() + " inventory for store : "
				+ deleteProductRequest.getDealerStoreId() + " is successfuly done");
		return response;
	}

	private StoreInventory getStoreAndProduct(Store store, Product product) {
		return storeInventoryRepository.findByStoreAndProduct(store, product);
	}

	private Product getProduct(ProductDTO product) {
		return productService.checkProduct(product.getProductName());
	}

	private Store getStore(String dealerStoreId) {
		return storeService.checkStore(dealerStoreId);
	}
}
