package com.ivcoding.mongobasiccrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ivcoding.mongobasiccrud.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	List<User> findByFirstName(String firstName);

	Optional<User> findByPhone(String phone);
}
