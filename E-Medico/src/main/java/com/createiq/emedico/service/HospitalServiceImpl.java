package com.createiq.emedico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.emedico.dao.HospitalRepository;
import com.createiq.emedico.entity.Hospital;
@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Hospital> findAll() {
		return hospitalRepository.findAll();
	}

	public Hospital findById(Integer hid) {
		return hospitalRepository.getById(hid);
	}

	public Hospital save(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public Hospital update(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public void deleteById(Integer hid) {
        hospitalRepository.deleteById(hid);		
	}

}
