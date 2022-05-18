package com.createiq.emedico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.emedico.dao.AddressRepository;
import com.createiq.emedico.dao.QualificationRepository;
import com.createiq.emedico.entity.Address;
import com.createiq.emedico.entity.Qualification;
@Service
public class QualificationServiceImpl implements QualificationService{

	@Autowired
	private QualificationRepository qualificationRepository;
	
	public List<Qualification> findAll() {
		return qualificationRepository.findAll();
	}

	public Qualification findById(Integer qid) {
		return qualificationRepository.getById(qid);
	}

	public Qualification save(Qualification qualification) {
		return qualificationRepository.save(qualification);
	}

	public Qualification update(Qualification qualification) {
		return qualificationRepository.save(qualification);
	}

	public void deleteById(Integer qid) {
		qualificationRepository.deleteById(qid);
	}

}
