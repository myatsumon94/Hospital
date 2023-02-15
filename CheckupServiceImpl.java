package com.hospital.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.hospital.entity.Checkup;
import com.hospital.repository.CheckupRepository;
import com.hospital.service.CheckupService;

@Service
public class CheckupServiceImpl implements CheckupService{
	
	private final CheckupRepository checkupRepository;

	
	public CheckupServiceImpl(CheckupRepository checkupRepository) {
		super();
		this.checkupRepository = checkupRepository;
	}

	@Override
	public Checkup saveCheckup(Checkup checkup) {
		
		return checkupRepository.save(checkup);
	}

	@Override
	public Checkup updateCheckup(Checkup checkup) {
		Optional<Checkup> checkupOpt = checkupRepository.findById(checkup.getId());
		
		if(checkupOpt.isPresent())
			checkup.setId(checkupOpt.get().getId());
		
		return checkupRepository.save(checkup);
	}	

	@Override
	public void deleteById(Long id) {
		
		checkupRepository.deleteById(id);
		
	}

	@Override
	public List<Checkup> findAll(){
		return (List<Checkup>) checkupRepository.findAll();
	}
	
	@Override
	public Optional<Checkup> findById(Long id) {
		
		return checkupRepository.findById(id);
	}


}
