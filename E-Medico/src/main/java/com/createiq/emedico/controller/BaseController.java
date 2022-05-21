package com.createiq.emedico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.emedico.util.MailSenderUtil;

@RestController
public class BaseController {
	@Autowired
	private MailSenderUtil mailSenderUtil;
	@GetMapping("/sendEmail")
	public String sendEmail() {
		return mailSenderUtil.sendEmail("noreply@createiq.com", "murali.vadlamudi46@gmail.com", "Hi Murali - This is Test Mail", "Test Mail");
		
	}

}
