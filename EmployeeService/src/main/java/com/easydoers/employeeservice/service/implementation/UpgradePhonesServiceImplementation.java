package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.entity.UpgradePhoneTransfer;
import com.easydoers.employeeservice.dto.PendingReceivesResponse;
import com.easydoers.employeeservice.dto.PendingTranfersResponse;
import com.easydoers.employeeservice.dto.PendingTransfersAndReceivesResponse;
import com.easydoers.employeeservice.dto.ReceiveUpgradePhoneRequest;
import com.easydoers.employeeservice.dto.StoreDTO;
import com.easydoers.employeeservice.dto.TransferUpgradePhoneRequest;
import com.easydoers.employeeservice.dto.UpgradePhonesDTO;
import com.easydoers.employeeservice.dto.UpgradePhonesInStoresResponse;
import com.easydoers.employeeservice.dto.UpgradePhonesInvoiceRequest;
import com.easydoers.employeeservice.dto.UpgradePhonesProductDTO;
import com.easydoers.employeeservice.dto.UpgradePhonesSoldRequest;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Product;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.UpgradePhoneReceive;
import com.easydoers.employeeservice.entity.UpgradePhones;
import com.easydoers.employeeservice.entity.UpgradePhonesInvoice;
import com.easydoers.employeeservice.entity.UpgradePhonesSale;
import com.easydoers.employeeservice.repository.ProductRepository;
import com.easydoers.employeeservice.repository.UpgradePhonesInvoiceRepository;
import com.easydoers.employeeservice.repository.UpgradePhonesReceiveRepository;
import com.easydoers.employeeservice.repository.UpgradePhonesRepository;
import com.easydoers.employeeservice.repository.UpgradePhonesSaleRepository;
import com.easydoers.employeeservice.repository.UpgradePhonesTranferRepostiory;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.UpgradePhonesService;

@Service
public class UpgradePhonesServiceImplementation implements UpgradePhonesService {

	@Autowired
	private UpgradePhonesRepository upgradePhonesRepository;
	@Autowired
	private UpgradePhonesInvoiceRepository upgradePhonesInvoiceRepository;
	@Autowired
	private UpgradePhonesSaleRepository upgradePhonesSaleRepository;
	@Autowired
	private UpgradePhonesTranferRepostiory upgradePhonesTranferRepostiory;
	@Autowired
	private UpgradePhonesReceiveRepository upgradePhonesReceiveRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CompanyService companyService;

	@Override
	public Map<String, Object> saveUpgradePhonesInvoice(UpgradePhonesInvoiceRequest upgradePhonesInvoiceRequest) {
		Map<String, Object> response = new HashMap<>();
		Employee employee = employeeService.checkEmployee(upgradePhonesInvoiceRequest.getEmployeeNtid());
		Store store = storeService.checkStore(upgradePhonesInvoiceRequest.getDealerStoreId());
		UpgradePhonesInvoice invoice = new UpgradePhonesInvoice();
		invoice.setAccountNumber(upgradePhonesInvoiceRequest.getAccountNumber());
		invoice.setActivatedDate(LocalDate.now());
		invoice.setAmount(upgradePhonesInvoiceRequest.getAmount());
		invoice.setEmployee(employee);
		invoice.setStore(store);
		invoice = upgradePhonesInvoiceRepository.save(invoice);
		for (UpgradePhonesProductDTO product : upgradePhonesInvoiceRequest.getProducts()) {
			UpgradePhones upgradePhones = new UpgradePhones();
			Product checkProduct = productRepository.findByProductName(product.getProductName());
			upgradePhones.setImei(product.getImei());
			upgradePhones.setProduct(checkProduct);
			upgradePhones.setInvoice(invoice);
			upgradePhones.setStore(store);
			upgradePhones.setPhoneNumber(product.getPhoneNumber());
			upgradePhonesRepository.save(upgradePhones);
		}
		response.put("message :",
				"Invoice is successfully saved for store : " + upgradePhonesInvoiceRequest.getDealerStoreId()
						+ " by employee : " + upgradePhonesInvoiceRequest.getEmployeeNtid());
		return response;
	}

	@Override
	public Map<String, Object> saveUpgradePhonesSale(UpgradePhonesSoldRequest upgradePhonesSoldRequest) {
		Map<String, Object> response = new HashMap<>();
		Employee employee = employeeService.checkEmployee(upgradePhonesSoldRequest.getEmployeeNtid());
		Store store = storeService.checkStore(upgradePhonesSoldRequest.getDealerStoreId());
		UpgradePhonesSale phonesSale = new UpgradePhonesSale();
		UpgradePhones upgradePhones = new UpgradePhones();
		phonesSale.setSoldDate(LocalDate.now());
		phonesSale.setSoldPrice(upgradePhonesSoldRequest.getSoldPrice());
		phonesSale.setSoldTo(upgradePhonesSoldRequest.getSoldTo());
		phonesSale.setSoldEmployee(employee);
		phonesSale.setSoldStore(store);
		phonesSale = upgradePhonesSaleRepository.save(phonesSale);
		upgradePhones = upgradePhonesRepository.findByImei(upgradePhonesSoldRequest.getProduct().getImei());
		upgradePhones.setSoldInfo(phonesSale);
		upgradePhonesRepository.save(upgradePhones);
		response.put("message :",
				"Sale is successfully saved for store : " + upgradePhonesSoldRequest.getDealerStoreId()
						+ " by employee : " + upgradePhonesSoldRequest.getEmployeeNtid());
		return response;
	}

	@Override
	public Map<String, Object> transferUpgradePhone(TransferUpgradePhoneRequest transferUpgradePhoneRequest) {
		Map<String, Object> response = new HashMap<>();
		UpgradePhones upgradePhones = new UpgradePhones();
		upgradePhones = upgradePhonesRepository.findByImei(transferUpgradePhoneRequest.getImei());
		Employee employee = employeeService.checkEmployee(transferUpgradePhoneRequest.getEmployeeNtid());
		Store store = storeService.checkStore(transferUpgradePhoneRequest.getDealerStoreId());
		UpgradePhoneTransfer phoneTransfer = new UpgradePhoneTransfer();
		phoneTransfer.setTransferDate(LocalDate.now());
		phoneTransfer.setTransferredEmployee(employee);
		phoneTransfer.setTransferedStore(store);
		phoneTransfer = upgradePhonesTranferRepostiory.save(phoneTransfer);
		upgradePhones.setTransfer(phoneTransfer);
		upgradePhonesRepository.save(upgradePhones);
		response.put("message :", "transfered successfully");
		return response;
	}

	@Override
	public Map<String, Object> receiveUpgradePhone(ReceiveUpgradePhoneRequest receiveUpgradePhoneRequest) {
		Map<String, Object> response = new HashMap<>();
		UpgradePhoneReceive receiveDevice = new UpgradePhoneReceive();
		Store store = storeService.checkStore(receiveUpgradePhoneRequest.getDealerStoreId());
		Employee employee = employeeService.checkEmployee(receiveUpgradePhoneRequest.getEmployeeNtid());
		UpgradePhones upgradePhones = upgradePhonesRepository
				.findByImeiAndTransferIsNotNullAndReceiveIsNull(receiveUpgradePhoneRequest.getImei());
		if (upgradePhones.getTransfer() != null) {
			upgradePhones.setStore(store);
			receiveDevice.setReceiveDate(LocalDate.now());
			receiveDevice.setTransferedEmployee(employee);
			receiveDevice.setTransferedStore(store);
			upgradePhones.setReceive(receiveDevice);
			upgradePhonesReceiveRepository.save(receiveDevice);
			upgradePhonesRepository.save(upgradePhones);

		}
		response.put("message :", "received successfully");
		return response;
	}

	@Override
	public List<UpgradePhonesInStoresResponse> getUpgradePhones(String employeeNtid) {
		List<UpgradePhonesInStoresResponse> response = new ArrayList<>();
		Employee employee = employeeService.checkEmployee(employeeNtid);
		Company company = companyService.getCompany(employee.getCompany().getCompanyId());
		List<Store> stores = storeService.getStoresUnderCompany(company);
		for (Store store : stores) {
			List<UpgradePhonesDTO> products = new ArrayList<>();
			List<UpgradePhones> fetchAllUpgradePhones = new ArrayList<>();
			UpgradePhonesInStoresResponse setUpResponse = new UpgradePhonesInStoresResponse();
			List<UpgradePhones> upgradePhones = upgradePhonesRepository
					.findByStoreAndTransferIsNullAndSoldInfoIsNullAndReceiveIsNull(store);
			List<UpgradePhones> fetchPhonesOnceTransferOrReceiving = upgradePhonesRepository
					.findByStoreAndTransferIsNotNullAndSoldInfoIsNullAndReceiveIsNotNull(store);
			fetchAllUpgradePhones.addAll(upgradePhones);
			fetchAllUpgradePhones.addAll(fetchPhonesOnceTransferOrReceiving);
			StoreDTO setStore = new StoreDTO();
			setStore.setDealerStoreId(store.getDealerStoreId());
			setStore.setStoreName(store.getStoreName());
			setUpResponse.setStore(setStore);
			if (fetchAllUpgradePhones != null) {
				for (UpgradePhones upgradePhone : fetchAllUpgradePhones) {
					Product productInfo = productRepository.findByProductId(upgradePhone.getProduct().getProductId());
					UpgradePhonesInvoice invoice = upgradePhonesInvoiceRepository
							.findByInvoiceId(upgradePhone.getInvoice().getInvoiceId());
					UpgradePhonesDTO product = new UpgradePhonesDTO();
					product.setId(upgradePhone.getId());
					product.setProductName(productInfo.getProductName());
					product.setImei(upgradePhone.getImei());
					product.setPhoneNumber(upgradePhone.getPhoneNumber());
					product.setActivationDate(invoice.getActivatedDate().toString());
					product.setDaysOld(getNumberDaysFromActivationDate(invoice.getActivatedDate()));
					products.add(product);
				}
				setUpResponse.setProducts(products);
				response.add(setUpResponse);
			}

		}
		return response;
	}

	private long getNumberDaysFromActivationDate(LocalDate activatedDate) {

		return ChronoUnit.DAYS.between(activatedDate, LocalDate.now());
	}

	@Override
	public PendingTransfersAndReceivesResponse getPendingTransfersAndReceivesInStore(String dealerStoreId) {
		List<PendingTranfersResponse> pendingTransfers = new ArrayList<>();
		List<PendingReceivesResponse> pendingReceives = new ArrayList<>();
		List<UpgradePhones> fetchReceives = new ArrayList<>();
		Store store = storeService.checkStore(dealerStoreId);
		List<UpgradePhones> upgradePhones = upgradePhonesRepository
				.findByStoreAndTransferIsNotNullAndSoldInfoIsNullAndReceiveIsNull(store);
		List<UpgradePhoneTransfer> listOfTransfers = upgradePhonesTranferRepostiory.findByTransferedStore(store);

		if (listOfTransfers != null && !listOfTransfers.isEmpty()) {
			for (UpgradePhoneTransfer upgradePhoneTransfer : listOfTransfers) {
				UpgradePhones receivePending = upgradePhonesRepository
						.findByTransfer_TransferIdAndReceiveIsNullAndSoldInfoIsNull(
								upgradePhoneTransfer.getTransferId());
				if (receivePending != null) {
					fetchReceives.add(receivePending);
				}
			}
		}

		if (fetchReceives != null && !fetchReceives.isEmpty()) {
			for (UpgradePhones getReceives : fetchReceives) {
				if (getReceives != null && getReceives.getTransfer() != null
						&& dealerStoreId.equals(getReceives.getTransfer().getTransferedStore().getDealerStoreId())) {
					PendingReceivesResponse receive = new PendingReceivesResponse();
					receive.setDeviceName(getReceives.getProduct().getProductName());
					receive.setImei(getReceives.getImei());
					receive.setTransferFrom(getReceives.getStore().getDealerStoreId());
					receive.setTransferedBy(getReceives.getTransfer().getTransferredEmployee().getEmployeeNtid());
					receive.setDate(getReceives.getTransfer().getTransferDate().toString());
					pendingReceives.add(receive);
				}
			}
		}

		if (upgradePhones != null) {
			for (UpgradePhones upgradePhone : upgradePhones) {
				PendingTranfersResponse transfer = new PendingTranfersResponse();
				transfer.setDeviceName(upgradePhone.getProduct().getProductName());
				transfer.setImei(upgradePhone.getImei());
				transfer.setDate(upgradePhone.getTransfer().getTransferDate().toString());
				transfer.setTransferTo(upgradePhone.getTransfer().getTransferedStore().getDealerStoreId().toString());
				transfer.setTransferedBy(
						upgradePhone.getTransfer().getTransferredEmployee().getEmployeeNtid().toString());
				pendingTransfers.add(transfer);
			}
		}
		return new PendingTransfersAndReceivesResponse(pendingTransfers, pendingReceives);
	}

}
