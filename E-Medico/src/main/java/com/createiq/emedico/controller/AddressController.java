package com.createiq.emedico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.emedico.entity.Address;
import com.createiq.emedico.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
  public String apiName() {
	return "Address API";
  }
  
  @GetMapping("/findAll")
  public ResponseEntity<List<Address>> findAll(){
	return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll());
  }
  
  
}
