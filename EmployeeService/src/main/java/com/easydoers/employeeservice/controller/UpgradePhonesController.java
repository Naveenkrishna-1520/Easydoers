package com.easydoers.employeeservice.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.ReceiveUpgradePhoneRequest;
import com.easydoers.employeeservice.dto.TransferUpgradePhoneRequest;
import com.easydoers.employeeservice.dto.UpgradePhonesInStoresResponse;
import com.easydoers.employeeservice.dto.UpgradePhonesInvoiceRequest;
import com.easydoers.employeeservice.dto.UpgradePhonesSoldRequest;
import com.easydoers.employeeservice.service.UpgradePhonesService;

@RestController
@RequestMapping("v1/upgradePhones")
public class UpgradePhonesController {

	@Autowired
	private UpgradePhonesService upgradePhonesService;

	@PostMapping("/invoice")
	public ResponseEntity<Map<String, Object>> saveInvoice(
			@RequestBody UpgradePhonesInvoiceRequest upgradePhonesInvoiceRequest) {
		Map<String, Object> response = upgradePhonesService.saveUpgradePhonesInvoice(upgradePhonesInvoiceRequest);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/sale")
	public ResponseEntity<Map<String, Object>> saveUpgradePhonesSaleDetails(
			@RequestBody UpgradePhonesSoldRequest upgradePhonesSoldRequest) {
		Map<String, Object> response = upgradePhonesService.saveUpgradePhonesSale(upgradePhonesSoldRequest);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@PostMapping("/transfer")
	public ResponseEntity<Map<String, Object>> transferUpgradePhoneToAnotheStore(
			@RequestBody TransferUpgradePhoneRequest transferUpgradePhoneRequest) {
		Map<String, Object> response = upgradePhonesService.transferUpgradePhone(transferUpgradePhoneRequest);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/receive")
	public ResponseEntity<Map<String, Object>> receiveUpgradePhone(@RequestBody ReceiveUpgradePhoneRequest receiveUpgradePhoneRequest){
		Map<String, Object> response = upgradePhonesService.receiveUpgradePhone(receiveUpgradePhoneRequest);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/inStore/{dealerStoreId}")
	public ResponseEntity<UpgradePhonesInStoresResponse> getAvailableUpgradePhones(@PathVariable String dealerStoreId){
		UpgradePhonesInStoresResponse response = upgradePhonesService.getUpgradePhones(dealerStoreId);
		return new ResponseEntity<UpgradePhonesInStoresResponse>(response, HttpStatus.OK);
		
	}
}
