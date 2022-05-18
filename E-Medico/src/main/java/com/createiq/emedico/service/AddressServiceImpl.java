package com.createiq.emedico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.emedico.dao.AddressRepository;
import com.createiq.emedico.entity.Address;
@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public Address findById(Integer aid) {
		return addressRepository.getById(aid);
	}

	public Address save(Address address) {
		return addressRepository.save(address);
	}

	public Address update(Address address) {
		return addressRepository.save(address);
	}

	public void deleteById(Integer aid) {
		addressRepository.deleteById(aid);
	}

}
