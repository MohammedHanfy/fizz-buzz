package com.hanfy.fizzbuzz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.hanfy.fizzbuzz.model.User;

/**
 * The Class Properties.
 */
@Configuration
@ConfigurationProperties(prefix = "properties")
@EnableConfigurationProperties
public class Properties {

	/** The user. */
	private User user;

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
