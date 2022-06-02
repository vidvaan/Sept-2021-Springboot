package com.createiq.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/public")
	public String publicUrl() {
		return "Every user can access it with out login";
	}


	@GetMapping("/user/hello")
	public String hello() {
		return "Hello Demo";
	}

	@GetMapping("/admin/welcome")
	public String sayWelcome() {
		return "Welcome Demo";
	}

	@GetMapping("/admin/hi")
	public String sayHi() {
		return "Say Demo";
	}

}
