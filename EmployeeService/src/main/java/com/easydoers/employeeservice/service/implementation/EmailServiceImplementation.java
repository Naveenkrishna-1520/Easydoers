package com.easydoers.employeeservice.service.implementation;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import jakarta.activation.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.easydoers.employeeservice.entity.Address;
import com.easydoers.employeeservice.entity.Invoice;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.service.EmailService;
import com.itextpdf.html2pdf.HtmlConverter;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;

@Service
public class EmailServiceImplementation implements EmailService {

	@Autowired
	private TemplateEngine templateEngine;
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendCompanyCreationEmail(String email, String companyName, String userName, String password) {

		Map<String, Object> companyDetails = getcompanyDetails(companyName, userName, password);
		// Populate Thymeleaf context
		Context context = new Context();
		context.setVariables(companyDetails);
		String htmlContent = templateEngine.process("CompanyCredentialsEmail", context);
		// Send email
		try {
			sendHtmlEmail(email, "Your Company Account Has Been Created", htmlContent);
		} catch (MessagingException e) {

		}

	}

	private void sendHtmlEmail(String email, String subject, String htmlContent) throws MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("snaveenkrishna157@gmail.com");
		helper.setTo(email);
		helper.setSubject(subject);
		helper.setText(htmlContent, true);
		// Set the sender's email address

		mailSender.send(message);
	}

	private Map<String, Object> getcompanyDetails(String companyName, String userName, String password) {
		Map<String, Object> companyDetails = new HashMap<>();
		companyDetails.put("companyName", companyName);
		companyDetails.put("username", userName);
		companyDetails.put("password", password);
		return companyDetails;
	}

	@Override
	public void sendManagerCredentialsEmail(String companyName, String managerName, String email, String password) {
		Map<String, Object> companyDetails = getManagerDetails(companyName, managerName, email, password);
		Context context = new Context();
		context.setVariables(companyDetails);
		String htmlContent = templateEngine.process("ManagerCredentialsEmail", context);
		// Send email
		try {
			sendHtmlEmail(email, "Your Manager Account Has Been Created", htmlContent);
		} catch (MessagingException e) {

		}

	}

	private Map<String, Object> getManagerDetails(String companyName, String managerName, String email,
			String password) {
		Map<String, Object> managerDetails = new HashMap<>();
		managerDetails.put("companyName", companyName);
		managerDetails.put("managerName", managerName);
		managerDetails.put("username", email);
		managerDetails.put("password", password);
		return managerDetails;
	}

	@Override
	public void sendStoreInvoiceEmailToCompany(Store store, String email, Invoice invoice) {
		Map<String, Object> invoiceDetails = setInvoiceDetails(store.getDealerStoreId(), store.getStoreName(),
				store.getCompany().getCompanyName(), store.getCompany().getCompanyAddress(), invoice.getInvoiceId(),
				invoice.getDate(), email);
		Map<String, Object> invoiceDetailsForEmail = setInvoiceDetailsEmail(store.getDealerStoreId(),
				invoice.getInvoiceId(), store.getCompany().getCompanyName());
		Context context = new Context();
		context.setVariables(invoiceDetails);
		String htmlContent = templateEngine.process("InvoicePDF", context);
		Context contextEmail = new Context();
		contextEmail.setVariables(invoiceDetailsForEmail);
		String htmlContentEmail = templateEngine.process("InvoiceEmail", contextEmail);
		// Generate PDF in-memory
		ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
		HtmlConverter.convertToPdf(htmlContent, pdfOutputStream);
		byte[] pdfBytes = pdfOutputStream.toByteArray();
		sendHtmlEmail(email, "Invoice for " + store.getStoreName(), pdfBytes, htmlContentEmail,
				store.getDealerStoreId());

	}

	private Map<String, Object> setInvoiceDetailsEmail(String dealerStoreId, String invoiceId, String companyName) {
		Map<String, Object> invoiceDetails = new HashMap<>();
		invoiceDetails.put("invoiceId", invoiceId);
		invoiceDetails.put("companyName", companyName);
		invoiceDetails.put("dealerStoreId", dealerStoreId);

		return invoiceDetails;
	}

	private Map<String, Object> setInvoiceDetails(String dealerStoreId, String storeName, String companyName,
			Address companyAddress, String invoiceId, LocalDate date, String email) {
		Map<String, Object> invoiceDetails = new HashMap<>();
		invoiceDetails.put("invoiceNumber", invoiceId);
		invoiceDetails.put("invoiceDate", date);
		invoiceDetails.put("companyName", companyName);
		invoiceDetails.put("companyAddress", companyAddress.getStreetName() + " " + companyAddress.getCity() + " "
				+ companyAddress.getState() + " " + companyAddress.getZipcode());
		invoiceDetails.put("storeName", storeName);

		return invoiceDetails;
	}

	private void sendHtmlEmail(String email, String subject, byte[] pdfBytes, String htmlContentEmail,
			String dealerStoreId) {
		try {
			// Create a MIME email message
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			// Set email properties
			helper.setFrom("snaveenkrishna157@gmail.com");
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(htmlContentEmail, true);

			// Attach PDF file using ByteArrayDataSource
			DataSource dataSource = new ByteArrayDataSource(pdfBytes, "application/pdf");
			helper.addAttachment("Invoice_" + dealerStoreId + ".pdf", dataSource);

			// Send email
			mailSender.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
