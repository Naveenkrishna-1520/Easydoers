package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.dto.CompanyDTO;
import com.easydoers.employeeservice.dto.CompanyResponse;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Invoice;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.repository.InvoiceRepository;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.EmailService;
import com.easydoers.employeeservice.service.InvoiceService;
import com.easydoers.employeeservice.service.StoreService;

@Service
public class InvoiceServiceImplementation implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private EmailService emailService;

	@Override
	public String generateInvoicesForAllCompanies() {
		List<Invoice> invoices = new ArrayList<>();
		int invoiceSize = 0;
		CompanyResponse fetchAllCompanies = companyService.fetchCompanies();
		for (CompanyDTO companyDTO : fetchAllCompanies.getCompanies()) {
			Company company = companyService.getCompany(companyDTO.getCompanyId());
			List<Store> storesUnderCompany = storeService.getStoresUnderCompany(company);
			invoiceSize = storesUnderCompany.size();
			for (Store store : storesUnderCompany) {
				Invoice invoice = generateInvoice(store, company.getEmail());
				invoices.add(invoice);
			}

		}
		invoiceRepository.saveAll(invoices);

		return "Sucessfully invoices generated for "+invoiceSize+" stores";
	}

	private Invoice generateInvoice(Store store, String email) {
		double invoiceAmount = 49.99;
		Invoice invoice = new Invoice(null, null, LocalDate.now(), invoiceAmount, store);
		invoice= invoiceRepository.save(invoice);
		emailService.sendStoreInvoiceEmailToCompany(store,email,invoice);
		return  invoice;
	}

}
