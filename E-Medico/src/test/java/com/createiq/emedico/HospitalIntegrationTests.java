package com.createiq.emedico;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.createiq.emedico.controller.HospitalController;
import com.createiq.emedico.entity.Hospital;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HospitalIntegrationTests {

	@Autowired
	HospitalController hospitalController;

	@Test
	public void testCreateReadDelete() {
        
		Hospital hospital = new Hospital();
		hospital.setHospitalName("SBH");
		hospital.setCity("SKLM");
		hospital.setState("AP");
		hospital.setCoutry("INDIA");
		hospital.setStartDate(new Date());
		hospital.setEndDate(new Date());
		
		hospitalController.save(hospital);
		
		
		List<Hospital> hospitals = hospitalController.findAll().getBody();
	    assertEquals("SBH", hospitals.get(0).getHospitalName());
	
	    hospitalController.deleteById(1);
	    
	    
	    
	    
	}
}
