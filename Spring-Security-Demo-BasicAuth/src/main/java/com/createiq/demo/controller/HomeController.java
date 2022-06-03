package com.createiq.demo.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.demo.dao.UserDAO;
import com.createiq.demo.model.UserDTO;

@RestController
public class HomeController {
	
	@Autowired
	private UserDAO userDAO;

	@GetMapping("/public")
	public UserDTO publicUrl() {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername("ram");
	    userDTO.setPassword("ram");
	    Set<String> autorities = new HashSet<>();
	    autorities.add("ROLE_USER");
	    userDTO.setAuthorities(autorities);
		
		return userDTO;
	}

	@PostMapping("/reg")
	public String reg(@RequestBody UserDTO userDTO) {
		
		userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
		userDAO.addUser(userDTO);
		
		return "User added Successfully ";
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
