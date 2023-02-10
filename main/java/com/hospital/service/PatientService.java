package com.hospital.service;

import java.util.List;
import java.util.Optional;
import com.hospital.entity.Patient;

public interface PatientService {
	
	Patient savePatient(Patient patient);
	
	Patient updatePatient(Patient patient);
	
	List<Patient> findAll();
	
	Optional<Patient> findById(Long id);
	
	Optional<Patient> findByDescription(String description);
	
	void deleteById(Long id);

}
