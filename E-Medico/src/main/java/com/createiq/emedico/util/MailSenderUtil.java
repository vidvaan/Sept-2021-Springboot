package com.createiq.emedico.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailSenderUtil {

	@Autowired
	private JavaMailSender javaMailSender;

	public String sendEmail(String from, String to, String body, String subject) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		// Setting up necessary details
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);

		// Sending the mail
		javaMailSender.send(mailMessage);
		return "Mail has been sent ? ";
	}

}
