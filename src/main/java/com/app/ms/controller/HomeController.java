package com.app.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ms.security.entity.User;
import com.app.ms.service.UserOrdersService;

@RestController
public class HomeController {

	@Autowired
	private UserOrdersService userOrderService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		
		List<User> users = userOrderService.getUsers();
		return ResponseEntity.ok().body(users);
	}
	
	
	
	
	
	
}
