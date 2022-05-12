package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.EmployeeDAO;

@SpringBootApplication
public class SpringBootH2DbExampleApplication implements ApplicationRunner{
	
	private static final Logger LOGGER= LoggerFactory.getLogger(SpringBootH2DbExampleApplication.class);
	
	@Autowired
	private EmployeeDAO employeeDAO;

	public static void main(String[] args) {
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
		SpringApplication.run(SpringBootH2DbExampleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//System.out.println("I am spring boot app runner");
		employeeDAO.findAll().forEach(System.out::println);
	}

}
