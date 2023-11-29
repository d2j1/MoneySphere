package com.app.ms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ms.entities.User;
import com.app.ms.payloads.UserDto;
import com.app.ms.repository.UserRepo;
import com.app.ms.service.UserService;

import com.app.ms.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.UserDtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.UserToUserDto(savedUser);
		
		}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		
		User user = this.userRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("User","Id", userId));
		
		// update the data
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updated = this.userRepo.save(user);
		
		return this.UserToUserDto(updated);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","Id",userId));
		
		
		return this.UserToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> users = userRepo.findAll();
		

		List<UserDto> userDtos = users.stream().map(user -> this.UserToUserDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow( () -> new ResourceNotFoundException("User", "Id", userId));
		this.userRepo.delete(user);
	}

	
	// convert dto to user
	private User UserDtoToUser(UserDto userDto) {

		User user = new User();

		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		return user;
	}

	// convert user to DTO
	private UserDto UserToUserDto(User user) {

		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());

		return userDto;
	}

}
