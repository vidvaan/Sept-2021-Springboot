package com.createiq.emedico.service;

import java.util.List;

import com.createiq.emedico.entity.Address;
import com.createiq.emedico.entity.Hospital;

public interface HospitalService {
	
	List<Hospital> findAll();
	
	Hospital findById(Integer hid);
	
	Hospital save(Hospital hospital);
	
	Hospital update(Hospital hospital);
	
	void deleteById(Integer hid);

}
