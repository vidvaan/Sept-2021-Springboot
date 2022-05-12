package com.create.demo.service;

import java.util.List;

import com.create.demo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	Employee findById(int eid);
	Employee save(Employee employee);
	void update(Employee employee);
	void delete(int eid);
	List<Employee> findByEname(String ename);

}
