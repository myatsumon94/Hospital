package com.hospital.service;

import java.util.List;
import java.util.Optional;

import com.hospital.entity.Checkup;

public interface CheckupService {

	
	Checkup saveCheckup(Checkup checkup);
	
	Checkup updateCheckup(Checkup checkup);
	
	List<Checkup> findAll();
	
	Optional<Checkup> findById(Long id);
	
	void deleteById(Long id);

}
