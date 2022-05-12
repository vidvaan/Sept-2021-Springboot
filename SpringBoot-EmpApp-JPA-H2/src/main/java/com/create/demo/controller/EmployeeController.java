package com.create.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.create.demo.entity.Employee;
import com.create.demo.model.ResponseBean;
import com.create.demo.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/findById/{eid}")
	public ResponseBean findById(@PathVariable("eid") int eid) {

		Employee employee = employeeService.findById(eid);
		ResponseBean responseBean = null;
		if (employee != null) {
			responseBean = new ResponseBean(200, employee);
			return responseBean;
		}
		responseBean = new ResponseBean(404, "Record Not found with eid " + eid);
		return responseBean;
	}
	
	@GetMapping("/findByEname/{ename}")
	public ResponseEntity<Object> findByEname(@PathVariable("ename") String ename) {
		List<Employee> employees = employeeService.findByEname(ename);
		return ResponseEntity.status(HttpStatus.FOUND).body(employees);
	}

	@GetMapping("/findAll")
	public ResponseBean findAll() {
		ResponseBean responseBean = new ResponseBean(200, employeeService.findAll());
		return responseBean;
	}

	@PostMapping("/save")
	public ResponseBean save(@RequestBody Employee employee) {
		Employee emp = employeeService.save(employee);
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("msg", "Inserted Successfully");
		resMap.put("data", emp);
		ResponseBean responseBean = new ResponseBean(200, resMap);
		return responseBean;
	}

	@PutMapping("/update")
	public ResponseBean update(@RequestBody Employee employee) {
		Employee emp = employeeService.save(employee);
		Map<String, Object> resMap = new HashMap<>();
		resMap.put("msg", "Updated Successfully");
		resMap.put("data", emp);
		ResponseBean responseBean = new ResponseBean(200, resMap);
		return responseBean;
	}

	@DeleteMapping("/delete/{eid}")
	public ResponseEntity<Object> delete(@PathVariable("eid") int eid) {
		employeeService.delete(eid);
		Map<String, Object> map = new HashMap<>();
		map.put("status", HttpStatus.OK);
		map.put("msg", "Deleted with id "+eid);
		return ResponseEntity.ok(map);
	}

}
