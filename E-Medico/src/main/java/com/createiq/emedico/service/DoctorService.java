package com.createiq.emedico.service;

import java.util.List;

import com.createiq.emedico.entity.Address;
import com.createiq.emedico.entity.Doctor;

public interface DoctorService {
	
	List<Doctor> findAll();
	
	Doctor findById(Integer did);
	
	Doctor save(Doctor doctor);
	
	Doctor update(Doctor doctor);
	
	void deleteById(Integer did);

}
