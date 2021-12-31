package com.ederweb.eder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ederweb.eder.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
		
	}

