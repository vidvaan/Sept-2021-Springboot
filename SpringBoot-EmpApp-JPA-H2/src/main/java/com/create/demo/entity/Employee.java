package com.create.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries(value = {
		@NamedQuery(name = "Employee.getByEname", query = "select e from Employee e where e.ename = :ename"),
		@NamedQuery(name = "Employee.getByEsal", query = "select e from Employee e where e.esal = :esal")})
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	@Column
	private String ename;
	@Column
	private Double esal;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer eid, String ename, Double esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getEsal() {
		return esal;
	}

	public void setEsal(Double esal) {
		this.esal = esal;
	}

}
