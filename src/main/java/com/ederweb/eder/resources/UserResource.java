package com.ederweb.eder.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ederweb.eder.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource { //pacote de recurso para aplicação
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345"); 
		//L apos o 1 siguinifica Long na classe User
		return ResponseEntity.ok().body(u);
	}

}
