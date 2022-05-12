package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int eid);
	void save(Employee employee);
	void update(Employee employee);
	void delete(int eid);

}
