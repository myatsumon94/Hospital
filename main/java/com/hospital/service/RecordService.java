package com.hospital.service;

import java.util.List;
import java.util.Optional;

import com.hospital.entity.Record;

public interface RecordService {
	
	Record createRecord(Record record);
	
	Optional<Record> findById(Long id);
	
	//Optional<Record> findByDate(LocalDate date);
	
	//Optional<Record> findByPatient_id(Long patient_id);
	
	
	List<Record> findAll();
}
