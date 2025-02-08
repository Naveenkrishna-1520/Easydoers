package com.easydoers.employeeservice.service.implementation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.easydoers.employeeservice.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

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

}
