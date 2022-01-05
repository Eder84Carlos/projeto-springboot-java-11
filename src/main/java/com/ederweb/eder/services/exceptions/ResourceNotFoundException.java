package com.ederweb.eder.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) { //tratar a exceção na busca de um Id inexiteste no banco de dados
		super("Resource not found. Id" + id);
		
		
		
	}

}
