package com.createiq.emedico;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.createiq.emedico.controller.HospitalController;

@SpringBootTest
class EMedicoApplicationTests {
	
	@Autowired
	private HospitalController hospitalController;

	@Test
	void contextLoads() {
		 assertThat(hospitalController).isNotNull();
	}

}
