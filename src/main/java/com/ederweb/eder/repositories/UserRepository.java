package com.ederweb.eder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederweb.eder.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

		
	}

