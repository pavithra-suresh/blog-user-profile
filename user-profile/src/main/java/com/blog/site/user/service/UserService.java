package com.blog.site.user.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.site.user.model.User;
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
	public boolean registerUser(User user) {
		
		// Perform user validation
		boolean isValidUser = utils.validateUser(user);
		if(!isValidUser) {
			logger.info("Given user details are not valid");
			return false;
		}
		
		User savedUser = userRepo.insert(user);
		logger.info("Saved user : {}", savedUser);
		
		return savedUser != null? true: false;
	}

}
