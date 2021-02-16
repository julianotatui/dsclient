package com.devsuperior.dsclient.services;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String msg) {
		super(msg); // passa a mensagem para a superclasse RuntimeException
		
		
	}

}
