package com.app.ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.ms.entities.User;
import com.app.ms.payloads.UserDto;
import com.app.ms.repository.UserRepo;
import com.app.ms.service.UserService;

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
	public UserDto updateUser(UserDto user, Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub

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
