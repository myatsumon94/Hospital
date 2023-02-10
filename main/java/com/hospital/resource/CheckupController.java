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
import com.hospital.entity.Checkup;
import com.hospital.service.CheckupService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/checkup")
public class CheckupController {

	
	private final CheckupService checkupService;

	public CheckupController(CheckupService checkupService) {
		super();
		this.checkupService = checkupService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Checkup> createCheckup(@Valid @RequestBody Checkup checkup){
		
		Checkup createdCheckup = checkupService.saveOrUpdateCheckup(checkup);
		
		return new ResponseEntity<Checkup>(createdCheckup,HttpStatus.CREATED);
	}
	

	@GetMapping("/all")
	public List<Checkup> findAll(){
		
		List<Checkup> checkups = checkupService.findAll();
		return checkups;
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<Checkup> checkupOptional = checkupService.findById(id);
		
		if(checkupOptional.isEmpty())
			return new ResponseEntity<String>( "Checkup with id = " + id + " is not found ",HttpStatus.NOT_FOUND);
	
	   return new ResponseEntity<Checkup>(checkupOptional.get(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		
		checkupService.deleteById(id);
		
		return new ResponseEntity<String>("Deleted id = " + id,HttpStatus.OK);
	}
	
}
