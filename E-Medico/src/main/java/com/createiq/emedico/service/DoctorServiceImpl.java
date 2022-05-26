package com.createiq.emedico.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.emedico.dao.DoctorRepository;
import com.createiq.emedico.dao.HospitalRepository;
import com.createiq.emedico.dao.SpecializationRepository;
import com.createiq.emedico.entity.Doctor;
import com.createiq.emedico.entity.Hospital;
import com.createiq.emedico.entity.Specialization;
@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private SpecializationRepository specializationRepository;
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public List<Doctor> findAll() {
		return doctorRepository.findAll();
	}

	public Doctor findById(Integer did) {
		return doctorRepository.getById(did);
	}

	public Doctor save(Doctor doctor) {
		Hospital hospital = hospitalRepository.getById(doctor.getHospital().getId());
		List<Specialization> specializations = doctor.getSpecializations().stream().map(spe -> specializationRepository.getById(spe.getId())).collect(Collectors.toList());
		doctor.setHospital(hospital);
		doctor.setSpecializations(specializations);
		
		hospitalRepository.save(hospital);
		specializations.forEach(spe-> specializationRepository.save(spe));
		
		
		
		
		return doctorRepository.save(doctor);
	}

	public Doctor update(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public void deleteById(Integer did) {
		doctorRepository.deleteById(did);
	}

}
