package com.ivcoding.mongobasiccrud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateUserRequest {
	private String firstName;
	private String lastName;
	private String phone;
}
