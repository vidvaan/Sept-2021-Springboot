package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
@RestController
@RequestMapping("/rest/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/findById/{eid}")
	public Employee findById(@PathVariable("eid") int eid) {
		return new Employee(1, "Balaji", 20000.00);
	}
	
	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

}
