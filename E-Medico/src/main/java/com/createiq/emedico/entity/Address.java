package com.createiq.emedico.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	
	
	}
