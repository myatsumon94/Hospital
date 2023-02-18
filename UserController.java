package com.hospital.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hospital.entity.User;
import com.hospital.service.MapValidationErrorService;
import com.hospital.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

	private final UserService userService;
	private final MapValidationErrorService mapValidationErrorService;
	
	public UserController(UserService userService, MapValidationErrorService mapValidationErrorService) {
		super();
		this.userService = userService;
		this.mapValidationErrorService = mapValidationErrorService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> saveOrUpdateUser(@Valid @RequestBody User user){
		
	  User createdUser = userService.saveOrUpdateUser(user);
		
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<User> findAll(){
		
		List<User> users = userService.findAll();
		return users;		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<User> userOptional = userService.getUserById(id);
		if(userOptional.isEmpty())
			return new ResponseEntity<String>("User with id"+ id +"is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userOptional.get(),HttpStatus.OK);
		
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<?> findByUsername(@PathVariable String username){
		
		Optional<User> userOptional = userService.findByUsername(username);
		
		if(userOptional.isEmpty())
			return new ResponseEntity<String>("User with username"+ username +"is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userOptional.get(),HttpStatus.OK);
		
	}
	public UserService getUserService() {
		
		return userService;
	}

	public MapValidationErrorService getMapValidationErrorService() {
		return mapValidationErrorService;
	}

	
	
}
