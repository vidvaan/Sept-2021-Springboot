package com.createiq.emedico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.emedico.dao.AddressRepository;
import com.createiq.emedico.dao.DoctorRepository;
import com.createiq.emedico.entity.Address;
import com.createiq.emedico.entity.Doctor;
@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	public Doctor findById(Integer did) {
		return doctorRepository.getById(did);
	}

	public Doctor save(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctor update(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public void deleteById(Integer did) {
		doctorRepository.deleteById(did);
	}

}
