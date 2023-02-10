package com.hospital.service;

//import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hospital.entity.Appointment;

public interface AppointmentService {

	Appointment saveOrUpdateAppointment(Appointment appointment);
	
	Optional<Appointment> findById(Long id);
	
	List<Appointment> findAll();
	
	void deleteById(Long id);
	
	Optional<Appointment> findByDescription(String description);
	
	// Optional<Appointment> findByDate(LocalDate date);
	
}
