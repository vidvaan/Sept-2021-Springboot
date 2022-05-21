package com.createiq.emedico.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String mobile;
	private String email;
	private String profrssionalStmt;
	private String practicingFrom;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="aid")
	//@JsonIgnore
	private Address address;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="qid")
	//@JsonIgnore
	private Qualification qualification;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="doctor_specialization", joinColumns = {@JoinColumn(name="did",referencedColumnName = "id")},inverseJoinColumns= {@JoinColumn(name="sid",referencedColumnName="id")})
	//@JsonIgnore
	private List<Specialization> specializations;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="hid")
	//@JsonIgnore
	private Hospital hospital;
}
