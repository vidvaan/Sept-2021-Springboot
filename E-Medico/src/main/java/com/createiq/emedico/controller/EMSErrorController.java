package com.createiq.emedico.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.createiq.emedico.exception.HospitalNotFoundException;

@ControllerAdvice
public class EMSErrorController{
   @ExceptionHandler(HospitalNotFoundException.class)
   public ResponseEntity<?> hospitalNotFoundError(HospitalNotFoundException ex){
	   Map<String, String> map = new HashMap<>();
	   map.put("errMsg", ex.getMessage());
	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
   }
   
   @ExceptionHandler(Exception.class)
   public ResponseEntity<?> anyException(Exception ex){
	   Map<String, String> map = new HashMap<>();
	   map.put("errMsg", ex.getMessage());
	   return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(map);
   }
}
