package com.app.ms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	
	@GetMapping("/")
	public String help() {
		return "ans";
	}
}
