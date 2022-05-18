package com.createiq.emedico.service;

import java.util.List;

import com.createiq.emedico.entity.Address;

public interface AddressService {
	
	List<Address> findAll();
	
	Address findById(Integer aid);
	
	Address save(Address address);
	
	Address update(Address address);
	
	void deleteById(Integer aid);

}
