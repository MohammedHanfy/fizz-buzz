package com.hanfy.fizzbuzz.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * The Class SecurityConfig.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/** The properties. */
	private Properties properties;
	
	/**
	 * Instantiates a new security config.
	 *
	 * @param properties the properties
	 */
	public SecurityConfig(Properties properties) {
		this.properties = properties;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.requestMatcher(EndpointRequest.toAnyEndpoint())
			.authorizeRequests()
			.anyRequest()
			.hasRole("ADMIN")
			.and()
			.httpBasic();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		
    	PasswordEncoder encoder = 
    			PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails user = User
				.withUsername(properties.getUser().getName())
				.password(encoder.encode(properties.getUser().getPassword()))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}