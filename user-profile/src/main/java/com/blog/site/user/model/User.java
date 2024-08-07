package com.blog.site.user.model;


import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@NotEmpty(message = "User name should not be empty")
	private String userName;
	
	@NotEmpty(message = "Email should not be empty")
	private String email;
	
	@NotEmpty(message = "Password should not be empty")
	private String password;
}
