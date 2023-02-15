package com.hospital.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.hospital.entity.Record;

public interface RecordRepository extends CrudRepository<Record,Long>{
   
  // Optional<Record> findByDate(LocalDate date);
   
	List<Record> findAll();

}