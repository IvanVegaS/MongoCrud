package com.ivcoding.mongobasiccrud.mapper;

import com.ivcoding.mongobasiccrud.domain.CreateUserRequest;
import com.ivcoding.mongobasiccrud.model.User;

import ma.glasnost.orika.MapperFactory;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;

public class UsersMapping implements OrikaMapperFactoryConfigurer {

	@Override
	public void configure(MapperFactory orikaMapperFactory) {
		orikaMapperFactory.classMap(CreateUserRequest.class, User.class).byDefault().register();
	}

}
