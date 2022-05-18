package com.createiq.emedico.service;

import java.util.List;

import com.createiq.emedico.entity.Address;
import com.createiq.emedico.entity.Qualification;
import com.createiq.emedico.entity.Specialization;

public interface SpecializationService {
	
	List<Specialization> findAll();
	
	Specialization findById(Integer sid);
	
	Specialization save(Specialization specialization);
	
	Specialization update(Specialization specialization);
	
	void deleteById(Integer sid);

}
