package com.createiq.emedico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.emedico.dao.HospitalRepository;
import com.createiq.emedico.entity.Hospital;
import com.createiq.emedico.exception.HospitalNotFoundException;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	public List<Hospital> findAll() {
		return hospitalRepository.findAll();
	}

	public Hospital findById(Integer hid) {
		Optional<Hospital> hospitalOp = hospitalRepository.findById(hid);
		if (!hospitalOp.isPresent()) {
			throw new HospitalNotFoundException("With this Hid Hospital Not Found");
		}
		return hospitalOp.get();
	}

	public Hospital save(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public Hospital update(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	public void deleteById(Integer hid) {
		if (!hospitalRepository.findById(hid).isPresent()) {
			throw new HospitalNotFoundException("With this Hid Hospital Not Found");
		}
		hospitalRepository.deleteById(hid);
	}

}
