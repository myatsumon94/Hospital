package com.hospital.service;

import java.util.List;
import java.util.Optional;
import com.hospital.entity.Record;

public interface RecordService {
	
	Record saveRecord(Record record);
	
	Record updateRecord(Record record);
	
	Optional<Record> findById(Long id);
	
	List<Record> findAll();
	
	void deleteById(Long id);
}
