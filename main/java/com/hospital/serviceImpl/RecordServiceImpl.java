package com.hospital.serviceImpl;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.hospital.entity.Record;
import com.hospital.repository.RecordRepository;
import com.hospital.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{

	
	private final RecordRepository recordRepository;

	

	public RecordServiceImpl(RecordRepository recordRepository) {
		super();
		this.recordRepository = recordRepository;
	}


	@Override
	public Record createRecord(Record record) {
		// TODO Auto-generated method stub
		return recordRepository.save(record);
	}

	
	@Override
	public Optional<Record> findById(Long id) {
		// TODO Auto-generated method stub
		return recordRepository.findById(id);
	}

//	@Override
//	public Optional<Record> findByDate(LocalDate date) {
//		// TODO Auto-generated method stub
//		return recordRepository.findByDate(date);	}

	@Override
	public List<Record> findAll() {
		// TODO Auto-generated method stub
		return (List<Record>) recordRepository.findAll();
	}


//	@Override
//	public Optional<Record> findByPatient_id(Long patient_id) {
//		// TODO Auto-generated method stub
//		return recordRepository.findByPatient_id(patient_id);
//	}


	public RecordRepository getRecordRepository() {
		return recordRepository;
	}


}
