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

import com.createiq.emedico.entity.Doctor;
import com.createiq.emedico.entity.Hospital;
import com.createiq.emedico.entity.Qualification;
import com.createiq.emedico.service.QualificationService;

@RestController
@RequestMapping("/api/qualification/")
public class QualificationController {
	@Autowired
	private QualificationService qualificationService;

	public String apiName() {
		return "Qualification API";
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Qualification>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(qualificationService.findAll());
	}

	@GetMapping("/findById/{qid}")
	public ResponseEntity<Qualification> findById(Integer qid) {
		return ResponseEntity.status(HttpStatus.OK).body(qualificationService.findById(qid));
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<Qualification> save(@RequestBody Qualification qualification) {
		return ResponseEntity.status(HttpStatus.CREATED).body(qualificationService.save(qualification));
	}

	@PutMapping("/update")
	public ResponseEntity<Qualification> update(@RequestBody Qualification qualification) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(qualificationService.save(qualification));
	}

	@DeleteMapping("/deleteById/{hid}")
	public ResponseEntity<?> deleteById(Integer hid) {
		qualificationService.deleteById(hid);
		Map<String, String> responseMap = new HashMap<String, String>() {
			{
				put("response", "Deleted Successfully");
			}
		};
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseMap);
	}

	
}
