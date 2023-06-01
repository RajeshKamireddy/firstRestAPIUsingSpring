package com.in28minutes.springboot.firstrestapi.user;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserDetailsRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new UserDetails("Ranga", "Admin"));
		repository.save(new UserDetails("Ravi", "Admin"));
		repository.save(new UserDetails("John", ""));
		
//		List<UserDetails> users = repository.findAll();
		List<UserDetails> users = repository.findByRole("Admin");
		users.forEach(user -> logger.info(user.toString()));
	
	}

}
