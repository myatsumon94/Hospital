package com.hospital.serviceImpl;

import org.springframework.stereotype.Service;
import com.hospital.entity.Patient;
import com.hospital.repository.PatientRepository;
import com.hospital.service.PatientService;
import java.util.List;
import java.util.Optional;


@Service
public class PatientServiceImpl implements PatientService{


	private final PatientRepository patientRepository;

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}

	
//	@Override
//	public Patient savePatient(Patient patient) {
//		
////		Optional<Patient> patientOpt = patientRepository.findById(patient.getId());
//		
////		if(patientOpt.isPresent())
////			patient.setId(patientOpt.get().getId());
////		
//		return patientRepository.save(patient);
//		
//	}
	
	@Override
	public List<Patient> findAll(){
		return (List<Patient>) patientRepository.findAll();
	}


	@Override
	public Optional<Patient> findById(Long id) {
		return patientRepository.findById(id);
	}


	@Override
	public Optional<Patient> findByDescription(String description) {
		// TODO Auto-generated method stub
		return patientRepository.findByDescription(description);
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
		
	}


	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}


	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		Optional<Patient> patientOpt = patientRepository.findById(patient.getId());
		
		if(patientOpt.isPresent())
			patient.setId(patientOpt.get().getId());
		
		return patientRepository.save(patient);
	}

	

	

}
