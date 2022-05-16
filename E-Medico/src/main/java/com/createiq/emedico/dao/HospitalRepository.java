package com.createiq.emedico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.createiq.emedico.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
