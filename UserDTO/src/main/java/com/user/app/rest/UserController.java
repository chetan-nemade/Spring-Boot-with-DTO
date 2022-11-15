package com.user.app.rest;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.dto.UserDTO;
import com.user.app.entity.User;
import com.user.app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	private ModelMapper mapper=new ModelMapper();
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/user")
	public ResponseEntity saveUser(@RequestBody User user){		
		return new ResponseEntity(service.saveUser(user).getFirstname()+" is Successfully Saved!",HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDTO> getUserDetails(@PathVariable Integer userId) {	
		return new ResponseEntity<UserDTO>(mapper.map(service.getUser(userId), UserDTO.class),HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return new ResponseEntity<List<UserDTO>>(Arrays.asList(mapper.map(service.getAllUsers(), UserDTO[].class)),HttpStatus.OK);
	}
}
