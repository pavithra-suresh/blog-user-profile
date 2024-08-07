package com.blog.site.user.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import com.blog.site.user.model.User;

@Configuration
public class CommonUtils {
	
	private static Logger logger = LogManager.getLogger(CommonUtils.class);
	
	/**
	 * Method to validate user
	 * @param user
	 * @return
	 */
	public boolean validateUser(User user) {
		return isValidEmail(user.getEmail()) && 
				isValidPassword(user.getPassword());
	}

	/**
	 * Method to check if email contains "@" and ".com"
	 * @param email
	 * @return
	 */
	public boolean isValidEmail(String email) {
		
		if(email.contains("@") && email.endsWith(".com")) {
			logger.info("Email is valid");
			return true;
		}
		
		logger.error("Email doesn't contain @ or .com");
		return false;
	}

	/**
	 * Method to check if Password is Alphanumeric and at least 8 characters
	 * @param password
	 * @return
	 */
	public boolean isValidPassword(String password) {
		
		String validPasswordFormat = "^[A-Za-z0-9]{8,}$";
		Pattern pattern = Pattern.compile(validPasswordFormat);
		Matcher matcher = pattern.matcher(password);
		boolean isValid = matcher.matches();
		
		logger.info("Is valid password: {}", isValid);
		return isValid;
	}
}
