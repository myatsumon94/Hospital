package com.hospital.service;

import java.util.List;
import java.util.Optional;

import com.hospital.entity.User;

public interface UserService {

	User saveOrUpdateUser(User user);
	//User createUser(User user);
	List<User> findAll();
	Optional<User> findById(Long id);
	Optional<User> findByUsername(String username);
	Optional<User> getUserById(Long id);
	
	
}
