package com.create.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.create.demo.dao.EmployeeDAO;
import com.create.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public Employee findById(int eid) {
		if (employeeDAO.findById(eid).isPresent()) {
			return employeeDAO.findById(eid).get();
		}

		return null;
	}

	@Override
	public Employee save(Employee employee) {
		return employeeDAO.save(employee);
	}

	@Override
	public void update(Employee employee) {
		employeeDAO.save(employee);

	}

	@Override
	public void delete(int eid) {
		employeeDAO.deleteById(eid);
		

	}

	@Override
	public List<Employee> findByEname(String ename) {
		return employeeDAO.findByEname(ename);
	}

}
