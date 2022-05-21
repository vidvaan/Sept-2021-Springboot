package com.createiq.emedico.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String hospitalName;
	private String city;
	private String state;
	private String coutry;
	private Date startDate;
	private Date endDate;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hospital")
	@JsonIgnore
	private List<Doctor> doctors;

}
