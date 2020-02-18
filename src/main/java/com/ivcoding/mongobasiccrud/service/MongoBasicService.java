package com.ivcoding.mongobasiccrud.service;

import java.util.List;

import com.ivcoding.mongobasiccrud.domain.CreateUserRequest;
import com.ivcoding.mongobasiccrud.model.User;

public interface MongoBasicService {
	User createUser(CreateUserRequest request);

	List<User> getUsers(String firstName, String phone);
}
