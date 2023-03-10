package com.hospital.resource;

import java.util.List;
import java.util.Optional;
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
import com.hospital.entity.Record;
import com.hospital.service.RecordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/record")
@CrossOrigin(origins = "http://localhost:3000")
public class RecordController {
	
	private final RecordService recordService;

	
	public RecordController(RecordService recordService) {
		super();
		this.recordService = recordService;
	}

	public RecordService getRecordService() {
		return recordService;
	}

	@PostMapping("/create")
	public ResponseEntity<Record> createRecord(@Valid @RequestBody Record record){
		
		Record createdRecord = recordService.saveRecord(record);
		
		return new ResponseEntity<Record>(createdRecord,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<Record> updateRecord(@Valid @RequestBody Record record){
		
		Record updatedRecord = recordService.updateRecord(record);
			
		return new ResponseEntity<Record>(updatedRecord,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		
		recordService.deleteById(id);
		
		return new ResponseEntity<Long>(id,HttpStatus.OK);
	}

	
	@GetMapping("/all")
	public List<Record> findAll(){
		
		List<Record> records = recordService.findAll();
		return records;		
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<Record> recordOptional = recordService.findById(id);
			
		if(recordOptional.isEmpty())
			return new ResponseEntity<String>("record with id = " + id +" is not found ", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Record>(recordOptional.get(),HttpStatus.OK);
	}
	

//	@GetMapping("/patientId/{patient_id}")
//	public ResponseEntity<?> findByPatient_id(@PathVariable Long patient_id){
//		
//		Optional<Record> recordByPatientId = recordService.findByPatient_id(patient_id);
//		
//		
//		if(recordByPatientId .isEmpty())
//			return new ResponseEntity<String>("record with patient_id = " + patient_id +" is not found ", HttpStatus.NOT_FOUND);
//		
//		
//		return new ResponseEntity<Record>(recordByPatientId.get(),HttpStatus.OK);
//	}

}
