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
	public Record saveRecord(Record record) {
		// TODO Auto-generated method stub
		return recordRepository.save(record);
	}

	@Override
	public Record updateRecord(Record record) {
		Optional<Record> recordOpt = recordRepository.findById(record.getId());
		
		if(recordOpt.isPresent())
			record.setId(recordOpt.get().getId());
		
		return recordRepository.save(record);
	}
	
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		recordRepository.deleteById(id);
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

	

}
