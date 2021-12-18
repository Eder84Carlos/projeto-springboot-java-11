package com.ederweb.eder.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ederweb.eder.entities.User;
import com.ederweb.eder.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Loja 1", "loja1@gmail.com", "81-998524434", "484848"); 
		User u2 = new User(null, "Loja 2", "loja2@gmail.com", "81-35465545", "848484"); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
	
	

}
