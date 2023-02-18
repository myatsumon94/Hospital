package com.hospital.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hospital.entity.User;

public interface UserRepository extends CrudRepository<User,Long>{
	
	Optional<User> findByUsername(String username);
	
	Optional<User> getUserById(Long id);
}
