package com.blog.site.user.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.site.user.model.User;
import com.blog.site.user.service.IUserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private static Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	/**
	 * Method responsible to register a new user
	 * @return
	 */
	@PostMapping("/register")
	@ApiOperation(notes="Creates a user with provided details", value = "Register a new user")
	public boolean register(@RequestBody User user) {
		logger.info("Request received for new user registration : {}", user);
		
		return userService.registerUser(user);
	}
	

}
