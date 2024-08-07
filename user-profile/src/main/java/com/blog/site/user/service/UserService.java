package com.blog.site.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.site.user.entity.User;
import com.blog.site.user.model.UserDto;
import com.blog.site.user.repo.UserRepository;
import com.blog.site.user.utils.CommonUtils;

@Service
public class UserService implements IUserService {
	
	private static Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CommonUtils utils;

	@Override
	public boolean registerUser(UserDto userDto) {
		
		// Perform user validation
		boolean isValidUser = utils.validateUser(userDto);
		if(!isValidUser) {
			logger.info("Given user details are not valid");
			return false;
		}
		
		User user = new User(userDto.getUserName(), userDto.getEmail(), 
				userDto.getPassword());
		
		// Persisting User
		User savedUser = userRepo.save(user);
		logger.info("Saved user : {}", savedUser);
		
		//TODO publish to kafka
		
		return savedUser != null? true: false;
	}

}
