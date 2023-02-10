package com.hospital.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.hospital.entity.Appointment;
import com.hospital.repository.AppointmentRepository;
import com.hospital.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	
	private final AppointmentRepository appointmentRepository;
	

	
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
	}


	public AppointmentRepository getAppointmentRepository() {
		return appointmentRepository;
	}


	@Override
	public Appointment saveOrUpdateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentRepository.save(appointment);
	}



	@Override
	public Optional<Appointment> findById(Long id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(id);
	}


	@Override
	public List<Appointment> findAll() {
		// TODO Auto-generated method stub
		return (List<Appointment>) appointmentRepository.findAll();
	}

	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		appointmentRepository.deleteById(id);
	}


	@Override
	public Optional<Appointment> findByDescription(String description) {
		// TODO Auto-generated method stub
		return appointmentRepository.findByDescription(description);
	}


//	@Override
//	public Optional<Appointment> findByDate(LocalDate date) {
//		// TODO Auto-generated method stub
//		return appointmentRepository.findByDate(date);
//	}


	



}
