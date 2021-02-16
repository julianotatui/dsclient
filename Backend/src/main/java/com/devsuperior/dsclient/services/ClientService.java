package com.devsuperior.dsclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsclient.dto.ClientDto;
import com.devsuperior.dsclient.entities.Client;
import com.devsuperior.dsclient.repositories.ClientRepositories;

@Service
public class ClientService {
    
	@Autowired
	private ClientRepositories repository;
	
	@Transactional (readOnly = true) //garante a integridade da transação e as propriedades ACID - conceito do banco relacional. O readOnly evita o lock de tabelas
	public List<ClientDto> findAll(){
	     
		List<Client> list = repository.findAll();
		return list.stream().map(x -> new ClientDto(x)).collect(Collectors.toList());
		

	}
	
	@Transactional (readOnly = true) //garante a integridade da transação e as propriedades ACID - conceito do banco relacional. O readOnly evita o lock de tabelas
	public ClientDto findById(long id){
	     
		Optional<Client> obj = repository.findById(id); //Objeto optional evita trabalhar com valor nulo. O retorno nunca será nulo, sempre será um objeto optional sendo que dentro deste objeto pode ou não ser nulo
		Client entity = obj.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado !!!"));
		return new ClientDto(entity);

	}
	
}