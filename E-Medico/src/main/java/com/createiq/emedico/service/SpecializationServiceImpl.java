package com.createiq.emedico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.emedico.dao.AddressRepository;
import com.createiq.emedico.dao.QualificationRepository;
import com.createiq.emedico.dao.SpecializationRepository;
import com.createiq.emedico.entity.Address;
import com.createiq.emedico.entity.Qualification;
import com.createiq.emedico.entity.Specialization;

@Service
public class SpecializationServiceImpl implements SpecializationService {

	@Autowired
	private SpecializationRepository specializationRepository;

	public List<Specialization> findAll() {
		return specializationRepository.findAll();
	}

	public Specialization findById(Integer sid) {
		return specializationRepository.getById(sid);
	}

	public Specialization save(Specialization specialization) {
		return specializationRepository.save(specialization);
	}

	public Specialization update(Specialization specialization) {
		return specializationRepository.save(specialization);
	}

	public void deleteById(Integer sid) {
		specializationRepository.deleteById(sid);
	}

}
