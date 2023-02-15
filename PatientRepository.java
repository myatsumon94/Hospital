package com.hospital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hospital.entity.Patient;

public interface PatientRepository extends CrudRepository<Patient,Long>{
	
	Optional<Patient> findByDescription(String description);
	
	List<Patient> findAll();
	
}
