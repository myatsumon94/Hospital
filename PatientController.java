package com.hospital.resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.entity.Patient;
import com.hospital.service.PatientService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {


	private final PatientService patientService;
	

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@PostMapping("/create")
	public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient){
		
		Patient createdPatient  = patientService.savePatient(patient);
		
		return new ResponseEntity<Patient>(createdPatient,HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Patient> updatePatient(@Valid @RequestBody Patient patient){
		
		Patient updatedPatient  = patientService.updatePatient(patient);
		
		return new ResponseEntity<Patient>(updatedPatient,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Patient> findAll(){
		
		List<Patient> patients = patientService.findAll();
		return patients;		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<Patient> patientOptional = patientService.findById(id);
		
			if(patientOptional.isEmpty())
				return new ResponseEntity<String>( "Patient with id = " + id + " is not found ",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Patient>(patientOptional.get(),HttpStatus.OK);
	}
	
	@GetMapping("/description/{description}")
	public ResponseEntity<?> findByDescription(@PathVariable String description){
		
		Optional<Patient> patientOptional = patientService.findByDescription(description);
	
		if(patientOptional.isEmpty())
			return new ResponseEntity<String>("Patient with description " + description + " is not found ",HttpStatus.NOT_FOUND);

		return new ResponseEntity<Patient>(patientOptional.get(),HttpStatus.OK);

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		
		patientService.deleteById(id);
		
		return new ResponseEntity<Long>(id,HttpStatus.OK);
	}


	
}
