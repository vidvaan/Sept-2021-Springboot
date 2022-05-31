package com.createiq.emedico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.createiq.emedico.dao.HospitalRepository;
import com.createiq.emedico.entity.Hospital;
import com.createiq.emedico.service.HospitalServiceImpl;

@ExtendWith(MockitoExtension.class)
public class HospitalServiceTest {
	
	@Mock
	HospitalRepository hospitalRepository;
	
	@InjectMocks
	HospitalServiceImpl hospitalService;


	public List<Hospital> getHospitals() {
		List<Hospital> list = new ArrayList<Hospital>();
		Hospital hospital1 = new Hospital();
		hospital1.setId(1);
		hospital1.setHospitalName("KIMS");

		Hospital hospital2 = new Hospital();
		hospital2.setId(2);
		hospital2.setHospitalName("JEMS");
		list.add(hospital1);
		list.add(hospital2);
		return list;
	}

	@Test
	public void findAllTest() {
		when(hospitalRepository.findAll()).thenReturn(getHospitals());
		List<Hospital> hospitals = hospitalService.findAll();
		assertEquals(2, hospitals.size());
		assertEquals("KIMS", hospitals.get(0).getHospitalName());
		assertEquals("JEMS", hospitals.get(1).getHospitalName());
		verify(hospitalRepository, times(1)).findAll();
	}
	
	
	@Test
	public void saveTest() {
		Hospital hospital = new Hospital();
		hospital.setHospitalName("KIMS");
		hospital.setCity("SKLM");
		when(hospitalRepository.save(hospital)).thenReturn(hospital);
		hospitalService.save(hospital);
		verify(hospitalRepository, times(1)).save(hospital);
	}
	
	
	@Test
	public void updateTest() {
		Hospital hospital = new Hospital();
		hospital.setHospitalName("KIMS");
		hospital.setCity("SKLM");
		hospitalService.update(hospital);
		verify(hospitalRepository, times(1)).save(hospital);
	}

}
