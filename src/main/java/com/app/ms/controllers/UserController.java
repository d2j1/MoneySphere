package com.app.ms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ms.payloads.ApiResponse;
import com.app.ms.payloads.UserDto;
import com.app.ms.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	
	// post create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody  UserDto user) {
		
		UserDto createdUser= this.userService.createUser(user);
		
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		
	}
//	put - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody  UserDto user, @PathVariable Integer userId) {
		
		UserDto updatedUser= this.userService.updateUser(user, userId);
		
		return ResponseEntity.ok(updatedUser);
		
	}
	
//	delete - delete user
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId) {
		
		this.userService.deleteUser(userId);
		
		return new ResponseEntity( new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
		
	}
	
//	 get - get user
	@GetMapping("/")
	public ResponseEntity<?> getUsers() {
		
		List<UserDto> users = this.userService.getAllUsers();
		
		return ResponseEntity.ok().body(users);
		
	}
	
	// get user by id
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUsers(@PathVariable Integer userId) {
		
		UserDto user = this.userService.getUserById(userId);
		
		return ResponseEntity.ok().body(user);
		
	}
	
}
