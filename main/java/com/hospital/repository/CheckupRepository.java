package com.hospital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hospital.entity.Checkup;


public interface CheckupRepository extends CrudRepository<Checkup,Long>{

	List<Checkup> findAll();
	


}
