package com.ederweb.eder.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable{
	private static final long serialVersionUID = 1L; //iniciar o Id 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //anotações @ para ser uma entidade do sistema mapeada pelo JPA
	private Long id;
	private String name;
	
	@JsonIgnore //para não criar um loop no chamado de categoria e produto
	@ManyToMany(mappedBy = "categories")
	private Set<Product> products = new HashSet<>(); //
	
	public Category() {
		
	}

	public Category(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {            //para compara somente o Id
		return Objects.hash(id);
	}
	
	public Set<Product> getProducts() {
		return products;
	}


	@Override
	public boolean equals(Object obj) {  //para compara somente o Id
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(id, other.id);
	}
	
}
