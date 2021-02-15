package com.devsuperior.dsclient.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsclient.entities.Client;
import com.devsuperior.dsclient.repositories.ClientRepositories;

@Service
public class ClientService {
    
	@Autowired
	private ClientRepositories repository;
	
	public List<Client> findAll(){
	
		return repository.findAll();
	}
}
