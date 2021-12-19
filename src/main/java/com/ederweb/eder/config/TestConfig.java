package com.ederweb.eder.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ederweb.eder.entities.Category;
import com.ederweb.eder.entities.Order;
import com.ederweb.eder.entities.User;
import com.ederweb.eder.entities.enums.OrderStatus;
import com.ederweb.eder.repositories.CategoryRepository;
import com.ederweb.eder.repositories.OrderRepository;
import com.ederweb.eder.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); //salvando no banco de dados
		
		User u1 = new User(null, "Loja 1", "loja1@gmail.com", "81-998524434", "484848"); 
		User u2 = new User(null, "Loja 2", "loja2@gmail.com", "81-35465545", "848484"); 
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		

		userRepository.saveAll(Arrays.asList(u1, u2)); //salvando no banco de dados
		orderRepository.saveAll(Arrays.asList(o1, o2, o3)); //salvando no banco de dados
		
	}
	
	

}
