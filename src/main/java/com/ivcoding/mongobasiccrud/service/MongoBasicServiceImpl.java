package com.ivcoding.mongobasiccrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.ivcoding.mongobasiccrud.domain.CreateUserRequest;
import com.ivcoding.mongobasiccrud.model.User;
import com.ivcoding.mongobasiccrud.repository.UserRepository;

import io.micrometer.core.instrument.util.StringUtils;
import ma.glasnost.orika.MapperFacade;

@Service
public class MongoBasicServiceImpl implements MongoBasicService {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MongoBasicServiceImpl.class);

	@Autowired
	UserRepository repository;

	@Autowired
	private MapperFacade orikaMapperFacade;

	@Override
	public User createUser(CreateUserRequest request) {
		User user = new User();
		user = orikaMapperFacade.map(request, User.class);
		log.debug("Entity pre-saving - " + user);
		repository.save(user);
		log.debug("Entity post-saving - " + user);
		return user;
	}

	@Override
	public List<User> getUsers(String firstName, String phone) {
		List<User> users = new ArrayList<>();
		Optional<User> user = null;

		if (StringUtils.isNotBlank(phone)) {
			user = repository.findByPhone(phone);
			if (user != null && user.isPresent()) {
				users.add(user.get());
				return users;
			}
		}

		if (StringUtils.isNotBlank(firstName)) {
			users = repository.findByFirstName(firstName);
			if (!CollectionUtils.isEmpty(users))
				return users;
		}

		log.warn("No user was found for given phone & first name combination.");

		users = repository.findAll();

		log.debug("Records found on DB - " + users.toString());
		return users;
	}
}
