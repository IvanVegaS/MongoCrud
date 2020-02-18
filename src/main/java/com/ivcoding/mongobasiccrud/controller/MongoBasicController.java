package com.ivcoding.mongobasiccrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivcoding.mongobasiccrud.domain.CreateUserRequest;
import com.ivcoding.mongobasiccrud.model.User;
import com.ivcoding.mongobasiccrud.service.MongoBasicServiceImpl;

@RestController
public class MongoBasicController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MongoBasicController.class);

	@Autowired
	MongoBasicServiceImpl service;

	@GetMapping("/grettings")
	public String grettings(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new String("Hello " + name + "!");
	}

	@PostMapping("/user")
	public String postUser(@RequestBody CreateUserRequest request) {
		log.debug("Create user request - " + request.toString());
		return service.createUser(request).getId();
	}

	@GetMapping("/user")
	public List<User> getUsers(@RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "phone", required = false) String phone) {
		log.debug("Get users parameters - firstName=" + firstName + ", phone=" + phone);
		return service.getUsers(firstName, phone);
	}
}