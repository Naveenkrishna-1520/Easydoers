package com.easydoers.employeeservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.easydoers.employeeservice.dto.InvoiceDetailsResponse;
import com.easydoers.employeeservice.dto.PendingTransfersAndReceivesResponse;
import com.easydoers.employeeservice.dto.ReceiveUpgradePhoneRequest;
import com.easydoers.employeeservice.dto.TransferUpgradePhoneRequest;
import com.easydoers.employeeservice.dto.UpgradePhonesInStoresResponse;
import com.easydoers.employeeservice.dto.UpgradePhonesInvoiceRequest;
import com.easydoers.employeeservice.dto.UpgradePhonesSoldRequest;
import com.easydoers.employeeservice.dto.previouslySoldDevicesResponse;

public interface UpgradePhonesService {

	Map<String, Object> saveUpgradePhonesInvoice(UpgradePhonesInvoiceRequest upgradePhonesInvoiceRequest);

	Map<String, Object> saveUpgradePhonesSale(UpgradePhonesSoldRequest upgradePhonesSoldRequest);

	Map<String, Object> transferUpgradePhone(TransferUpgradePhoneRequest transferUpgradePhoneRequest);

	Map<String, Object> receiveUpgradePhone(ReceiveUpgradePhoneRequest receiveUpgradePhoneRequest);

	List<UpgradePhonesInStoresResponse> getUpgradePhones(String employeeNtid);

	PendingTransfersAndReceivesResponse getPendingTransfersAndReceivesInStore(String dealerStoreId);

	List<previouslySoldDevicesResponse> getPreviouslySoldDevicesInStore(String dealerStoreId, LocalDate startDate, LocalDate endDate);

	InvoiceDetailsResponse getInvoiceDetailsByImei(String imei);

}
