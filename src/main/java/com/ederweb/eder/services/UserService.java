package com.ederweb.eder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ederweb.eder.entities.User;
import com.ederweb.eder.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {  //inserir um novo objeto User no banco de dados
		return repository.save(obj); //por padrão esse metodo ja retorna o obj salvo
	}

}
