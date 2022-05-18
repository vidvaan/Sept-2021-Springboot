package com.createiq.emedico.service;

import java.util.List;

import com.createiq.emedico.entity.Address;
import com.createiq.emedico.entity.Qualification;

public interface QualificationService {
	
	List<Qualification> findAll();
	
	Qualification findById(Integer qid);
	
	Qualification save(Qualification qualification);
	
	Qualification update(Qualification qualification);
	
	void deleteById(Integer qid);

}
