package com.createiq.emedico;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.createiq.emedico.dao.HospitalRepository;
import com.createiq.emedico.entity.Hospital;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HospitalRepositoryTest {

	@Autowired
	HospitalRepository hospitalRepository;

	@Test
	public void testCreateReadDelete() {
        
		Hospital hospital = new Hospital();
		hospital.setHospitalName("KIMS");
		hospital.setCity("SKLM");
		hospital.setState("AP");
		hospital.setCoutry("INDIA");
		
		hospitalRepository.save(hospital);
		
		List<Hospital> hospitals = hospitalRepository.findAll();
		assertEquals("KIMS", hospitals.get(0).getHospitalName());
		
		hospitalRepository.deleteAll();
		
		assertThat(hospitalRepository.findAll()).isEmpty();
	}

}
