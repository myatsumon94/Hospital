package com.hospital.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hospital.entity.User;
import com.hospital.repository.UserRepository;
import com.hospital.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public UserRepository getUserRepository() {
		return userRepository;
	}

	@Override
	public User saveOrUpdateUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public List<User> findAll() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		
		return userRepository.getUserById(id);
	}

	


}
