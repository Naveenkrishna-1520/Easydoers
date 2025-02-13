package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.entity.UpgradePhoneTransfer;
import com.easydoers.employeeservice.dto.InvoiceDetailsResponse;
import com.easydoers.employeeservice.dto.PendingReceivesResponse;
import com.easydoers.employeeservice.dto.PendingTranfersResponse;
import com.easydoers.employeeservice.dto.PendingTransfersAndReceivesResponse;
import com.easydoers.employeeservice.dto.PreviouslySoldDevicesResponse;
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
		Employee employee = employeeService.checkEmployee(upgradePhonesInvoiceRequest.getEmployeeNtid());
		Store store = storeService.checkStore(upgradePhonesInvoiceRequest.getDealerStoreId());

		// Create and save the invoice
		UpgradePhonesInvoice invoice = new UpgradePhonesInvoice(null, // Assuming the ID is auto-generated
				upgradePhonesInvoiceRequest.getAccountNumber(), LocalDate.now(),
				upgradePhonesInvoiceRequest.getAmount(), store, employee);
		UpgradePhonesInvoice savedInvoice = upgradePhonesInvoiceRepository.save(invoice);

		// Save each product under the invoice
		upgradePhonesInvoiceRequest.getProducts().forEach(product -> saveUpgradePhone(savedInvoice, product, store));

		// Prepare response message
		return Collections.singletonMap("message",
				String.format("Invoice is successfully saved for store: %s by employee: %s",
						upgradePhonesInvoiceRequest.getDealerStoreId(), upgradePhonesInvoiceRequest.getEmployeeNtid()));
	}

	// method to save each product
	private void saveUpgradePhone(UpgradePhonesInvoice invoice, UpgradePhonesProductDTO product, Store store) {
		Product checkProduct = productRepository.findByProductName(product.getProductName());

		UpgradePhones upgradePhones = new UpgradePhones(null, invoice, checkProduct, product.getImei(),
				product.getPhoneNumber(), null, null, null, store);
		upgradePhonesRepository.save(upgradePhones);
	}

	@Override
	public Map<String, Object> saveUpgradePhonesSale(UpgradePhonesSoldRequest upgradePhonesSoldRequest) {
		Employee employee = employeeService.checkEmployee(upgradePhonesSoldRequest.getEmployeeNtid());
		Store store = storeService.checkStore(upgradePhonesSoldRequest.getDealerStoreId());
		UpgradePhonesSale phonesSale = upgradePhonesSaleRepository
				.save(new UpgradePhonesSale(null, upgradePhonesSoldRequest.getSoldTo(), LocalDate.now(),
						upgradePhonesSoldRequest.getSoldPrice(), store, employee));

		// Fetch and update the upgrade phone with the sale info
		UpgradePhones upgradePhone = upgradePhonesRepository
				.findByImei(upgradePhonesSoldRequest.getProduct().getImei());
		if (upgradePhone != null) {
			upgradePhone.setSoldInfo(phonesSale);
			upgradePhonesRepository.save(upgradePhone);
		}

		// Prepare response
		return Collections.singletonMap("message",
				String.format("Sale is successfully saved for store: %s by employee: %s",
						upgradePhonesSoldRequest.getDealerStoreId(), upgradePhonesSoldRequest.getEmployeeNtid()));
	}

	@Override
	public Map<String, Object> transferUpgradePhone(TransferUpgradePhoneRequest transferUpgradePhoneRequest) {
		// Fetch necessary entities
		UpgradePhones upgradePhones = upgradePhonesRepository.findByImei(transferUpgradePhoneRequest.getImei());
		Employee employee = employeeService.checkEmployee(transferUpgradePhoneRequest.getEmployeeNtid());
		Store targetStore = storeService.checkStore(transferUpgradePhoneRequest.getTargetDealerStoreId());

		// Create and save the transfer record using constructor
		UpgradePhoneTransfer phoneTransfer = upgradePhonesTranferRepostiory
				.save(new UpgradePhoneTransfer(null, LocalDate.now(), targetStore, employee));

		// Update and save the phone details
		upgradePhones.setTransfer(phoneTransfer);
		upgradePhones.setReceive(null); // Clear any pending receive information
		upgradePhonesRepository.save(upgradePhones);

		// Return a simplified response
		return Collections.singletonMap("message", "Transferred successfully");
	}

	@Override
	public Map<String, Object> receiveUpgradePhone(ReceiveUpgradePhoneRequest receiveUpgradePhoneRequest) {
		// Fetch necessary entities
		Store store = storeService.checkStore(receiveUpgradePhoneRequest.getReceivingDealerStoreId());
		Employee employee = employeeService.checkEmployee(receiveUpgradePhoneRequest.getEmployeeNtid());
		UpgradePhones upgradePhones = upgradePhonesRepository
				.findByImeiAndTransferIsNotNullAndReceiveIsNull(receiveUpgradePhoneRequest.getImei());

		// Process only if a valid transfer exists
		if (upgradePhones.getTransfer() != null) {
			// Create and save the receive entry
			UpgradePhoneReceive receiveDevice = upgradePhonesReceiveRepository
					.save(new UpgradePhoneReceive(null, LocalDate.now(), store, employee));

			// Update and save the phone details
			upgradePhones.setStore(store);
			upgradePhones.setReceive(receiveDevice);
			upgradePhonesRepository.save(upgradePhones);
		}

		// Return a simplified response
		return Collections.singletonMap("message", "Received successfully");
	}

	@Override
	public List<UpgradePhonesInStoresResponse> getUpgradePhones(String employeeNtid) {
		Employee employee = employeeService.checkEmployee(employeeNtid);
		Company company = companyService.getCompany(employee.getCompany().getCompanyId());
		List<Store> stores = storeService.getStoresUnderCompany(company);

		return stores.stream().map(this::buildStoreResponse).collect(Collectors.toList());
	}

	private UpgradePhonesInStoresResponse buildStoreResponse(Store store) {
		List<UpgradePhonesDTO> products = fetchAllUpgradePhones(store).stream().map(this::buildProductDTO)
				.collect(Collectors.toList());

		return new UpgradePhonesInStoresResponse(buildStoreDTO(store), products);
	}

	private StoreDTO buildStoreDTO(Store store) {
		return new StoreDTO(store.getDealerStoreId(), store.getStoreName());
	}

	private List<UpgradePhones> fetchAllUpgradePhones(Store store) {
		List<UpgradePhones> upgradePhones = upgradePhonesRepository
				.findByStoreAndTransferIsNullAndSoldInfoIsNullAndReceiveIsNull(store);

		List<UpgradePhones> phonesOnceTransferOrReceving = upgradePhonesRepository
				.findByStoreAndTransferIsNotNullAndSoldInfoIsNullAndReceiveIsNotNull(store);

		return Stream.concat(upgradePhones.stream(), phonesOnceTransferOrReceving.stream())
				.collect(Collectors.toList());
	}

	private UpgradePhonesDTO buildProductDTO(UpgradePhones upgradePhone) {

		return new UpgradePhonesDTO(upgradePhone.getId(), upgradePhone.getProduct().getProductName(),
				upgradePhone.getImei(), upgradePhone.getPhoneNumber(),
				upgradePhone.getInvoice().getActivatedDate().toString(),
				getNumberDaysFromActivationDate(upgradePhone.getInvoice().getActivatedDate()));
	}

	private long getNumberDaysFromActivationDate(LocalDate activatedDate) {

		return ChronoUnit.DAYS.between(activatedDate, LocalDate.now());
	}

	@Override
	public PendingTransfersAndReceivesResponse getPendingTransfersAndReceivesInStore(String dealerStoreId) {
		Store store = storeService.checkStore(dealerStoreId);

		// Fetch pending transfers and receives efficiently
		List<UpgradePhones> upgradePhones = upgradePhonesRepository
				.findByStoreAndTransferIsNotNullAndSoldInfoIsNullAndReceiveIsNull(store);

		List<PendingReceivesResponse> pendingReceives = upgradePhonesTranferRepostiory.findByTransferedStore(store)
				.stream()
				.map(transfer -> upgradePhonesRepository
						.findByTransfer_TransferIdAndReceiveIsNullAndSoldInfoIsNull(transfer.getTransferId()))
				.filter(receive -> receive != null && receive.getTransfer() != null
						&& dealerStoreId.equals(receive.getTransfer().getTransferedStore().getDealerStoreId()))
				.map(receive -> new PendingReceivesResponse(receive.getProduct().getProductName(), receive.getImei(),
						receive.getStore().getDealerStoreId(),
						receive.getTransfer().getTransferredEmployee().getEmployeeNtid(),
						receive.getTransfer().getTransferDate().toString()))
				.collect(Collectors.toList());

		List<PendingTranfersResponse> pendingTransfers = upgradePhones.stream()
				.map(phone -> new PendingTranfersResponse(phone.getProduct().getProductName(), phone.getImei(),
						phone.getTransfer().getTransferDate().toString(),
						phone.getTransfer().getTransferedStore().getDealerStoreId(),
						phone.getTransfer().getTransferredEmployee().getEmployeeNtid()))
				.collect(Collectors.toList());

		return new PendingTransfersAndReceivesResponse(pendingTransfers, pendingReceives);
	}

	@Override
	public List<PreviouslySoldDevicesResponse> getPreviouslySoldDevicesInStore(String dealerStoreId,
			LocalDate startDate, LocalDate endDate) {
		Store store = storeService.checkStore(dealerStoreId);

		return upgradePhonesRepository.findBySoldInfo_SoldStoreAndSoldInfo_SoldDateBetween(store, startDate, endDate)
				.stream()
				.map(upgradePhone -> new PreviouslySoldDevicesResponse(upgradePhone.getImei(),
						upgradePhone.getProduct().getProductName(), upgradePhone.getSoldInfo().getSoldTo(),
						upgradePhone.getSoldInfo().getSoldDate().toString(),
						upgradePhone.getSoldInfo().getSoldEmployee().getEmployeeNtid(),
						upgradePhone.getSoldInfo().getSoldStore().getDealerStoreId(),
						upgradePhone.getSoldInfo().getSoldPrice()))
				.collect(Collectors.toList());
	}

	@Override
	public InvoiceDetailsResponse getInvoiceDetailsByImei(String imei) {
		UpgradePhones invoiceDetails = upgradePhonesRepository.findByImei(imei);

		// Directly return the response using constructor initialization
		return new InvoiceDetailsResponse(invoiceDetails.getInvoice().getAccountNumber().toString(),
				invoiceDetails.getInvoice().getStore().getDealerStoreId(),
				invoiceDetails.getInvoice().getEmployee().getEmployeeNtid(),
				invoiceDetails.getInvoice().getActivatedDate().toString(), invoiceDetails.getInvoice().getAmount());
	}

}
