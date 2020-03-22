package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
@GetMapping("/")
public String home() {
	return("<h1>Welcome</h1>");
	//a home accessible to all users
}

@GetMapping("/user")
public String user() {
	//userInterface accessible to admin and user
	return("<h1>Welcome User</h1>");
}

@GetMapping("/admin")
public String admin() {
	//adminInterface only accessible to admin 
	return("<h1>Welcome Admin</h1>");
}
}
