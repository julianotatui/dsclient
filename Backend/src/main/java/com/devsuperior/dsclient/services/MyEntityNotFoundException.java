package com.devsuperior.dsclient.services;

public class MyEntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MyEntityNotFoundException(String msg) {
		super(msg); // passa a mensagem para a superclasse RuntimeException
		
		
	}

}
