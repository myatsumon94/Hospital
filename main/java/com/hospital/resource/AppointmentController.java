package com.hospital.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.entity.Appointment;
import com.hospital.service.AppointmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	private final AppointmentService appointmentService;

	public AppointmentController(AppointmentService appointmentService) {
		super();
		this.appointmentService = appointmentService;
	}

	@PostMapping("/create")
	public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody Appointment appointment){
		
		Appointment createdAppointment = appointmentService.saveOrUpdateAppointment(appointment);
		return new ResponseEntity<Appointment>(createdAppointment,HttpStatus.CREATED);
	}
	

	@GetMapping("/all")
	public List<Appointment> findAll(){
		
		List<Appointment> appointments = appointmentService.findAll();
		return appointments;		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<Appointment> appointmentOptional = appointmentService.findById(id);
		
			if(appointmentOptional.isEmpty())
				return new ResponseEntity<String>( "Appointment with id = " + id + " is not found ",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Appointment>(appointmentOptional.get(),HttpStatus.OK);
	}
	
	@GetMapping("/description/{description}")
	public ResponseEntity<?> findByDescription(@PathVariable String description){
		Optional<Appointment> appointmentOptional = appointmentService.findByDescription(description);
	
		if(appointmentOptional.isEmpty())
			return new ResponseEntity<String>("Appointment with description " + description + " is not found ",HttpStatus.NOT_FOUND);

		return new ResponseEntity<Appointment>(appointmentOptional.get(),HttpStatus.OK);

	}
	
//	@GetMapping("/date/{date}")
//	public ResponseEntity<?> findByDate(@PathVariable LocalDate date){
//		Optional<Appointment> appointmentOptional = appointmentService.findByDate(date);
//	
//		if(appointmentOptional.isEmpty())
//			return new ResponseEntity<String>("Appointment in day " + date + " is not found ",HttpStatus.NOT_FOUND);
//
//		return new ResponseEntity<Appointment>(appointmentOptional.get(),HttpStatus.OK);
//
//	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		
		appointmentService.deleteById(id);
		
		return new ResponseEntity<String>("Deleted id = " + id,HttpStatus.OK);
	}


	
	public AppointmentService getAppointmentService() {
		return appointmentService;
	}

}
