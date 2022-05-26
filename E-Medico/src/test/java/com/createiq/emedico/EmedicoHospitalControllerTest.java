package com.createiq.emedico;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.createiq.emedico.controller.HospitalController;
import com.createiq.emedico.entity.Hospital;
import com.createiq.emedico.service.HospitalService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(HospitalController.class)
public class EmedicoHospitalControllerTest {
	
	 @MockBean
	 HospitalService hospitalService;
	
	 @Autowired
	 MockMvc mockMvc;
	 
	 public List<Hospital>  getHospitals() {
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
	 
	 
	
	 
	 @BeforeEach
	 public void before() {
		
	 }
	 
	 @Test
	  public void testfindAll() throws Exception {
		 
		 Mockito.when(hospitalService.findAll()).thenReturn(getHospitals());
	    mockMvc.perform(get("/api/hospital/findAll"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", Matchers.hasSize(2)))
	        .andExpect(jsonPath("$[0].hospitalName", Matchers.is("KIMS")))
	        .andExpect(jsonPath("$[1].hospitalName", Matchers.is("JEMS")));
	  }
	 
	 @Test
	  public void testfinById() throws Exception {
		 Mockito.when(hospitalService.findById(1)).thenReturn(getHospitals().get(0));
	    mockMvc.perform(get("/api/hospital/findById/1"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.hospitalName", Matchers.is("KIMS")))
	        .andExpect(jsonPath("$.id", Matchers.is(1)));
	  }
	

}
