package com.createiq.emedico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.emedico.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
