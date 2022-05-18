package com.createiq.emedico.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.emedico.entity.Address;
import com.createiq.emedico.entity.Doctor;
import com.createiq.emedico.entity.Hospital;
import com.createiq.emedico.service.AddressService;
import com.createiq.emedico.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;

	public String apiName() {
		return "Doctor API";
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Doctor>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(doctorService.findAll());
	}

	@GetMapping("/findById/{did}")
	public ResponseEntity<Doctor> findById(Integer did) {
		return ResponseEntity.status(HttpStatus.OK).body(doctorService.findById(did));
	}

	@PostMapping("/save")
	public ResponseEntity<Doctor> save(@RequestBody Doctor doctor) {
		return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.save(doctor));
	}

	@PutMapping("/update")
	public ResponseEntity<Doctor> update(@RequestBody Doctor doctor) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(doctorService.save(doctor));
	}

	@DeleteMapping("/deleteById/{hid}")
	public ResponseEntity<?> deleteById(Integer hid) {
		doctorService.deleteById(hid);
		Map<String, String> responseMap = new HashMap<String, String>() {
			{
				put("response", "Deleted Successfully");
			}
		};
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseMap);
	}

}
