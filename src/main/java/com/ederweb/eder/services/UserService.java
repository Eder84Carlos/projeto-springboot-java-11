package com.ederweb.eder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ederweb.eder.entities.User;
import com.ederweb.eder.repositories.UserRepository;
import com.ederweb.eder.services.exceptions.DatabaseException;
import com.ederweb.eder.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id); //findById vai no banco de dados e pega o obj
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {  //inserir um novo objeto User no banco de dados
		return repository.save(obj); //por padrão esse metodo ja retorna o obj salvo
	}
	
	public void delete(Long id) { //deletar um usuario do banco de dados
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id); //tratamento para erro de consulta
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public User update(Long id, User obj) {
		User entity = repository.getOne(id); //getOne prepara o obj para depois execultar uma operção
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(User entity, User obj) { //metodo para atualizar dados do User
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
