package com.create.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.create.demo.entity.Employee;
import com.create.demo.service.EmployeeService;

@SpringBootApplication
public class SpringBootEmpAppJpaH2Application implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmpAppJpaH2Application.class, args);
	}

	@Autowired
	private EmployeeService employeeService;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Employee e1 = new Employee();
		e1.setEname("Balaji");
		e1.setEsal(20000.00);
		
		Employee e2 = new Employee();
		e2.setEname("Raja");
		e2.setEsal(20000.00);
		
		employeeService.save(e1);
		
		employeeService.save(e2);
	}
	
	

}
