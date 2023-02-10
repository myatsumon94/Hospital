package com.hospital.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.hospital.entity.Appointment;


public interface AppointmentRepository extends CrudRepository<Appointment, Long>{

	Optional<Appointment> findByDescription(String description);
	
  //  Optional<Appointment> findByDate(LocalDate date);
	
}
