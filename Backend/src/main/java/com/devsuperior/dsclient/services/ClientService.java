package com.devsuperior.dsclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

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
	
	@Transactional
	public ClientDto insert(ClientDto dto) {
		
		Client entity = new Client();
		
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIcome(dto.getIcome());
		entity.setChildren(dto.getChildren());
		entity.setBirthDate(dto.getBirthDate());
		
	    entity = repository.save(entity); //Responsável por salvar
	    
	    return new ClientDto(entity);
	    
		
	}
	
	@Transactional
	public ClientDto update(long id, ClientDto dto){
	    try { 
		        Client entity = repository.getOne(id); // o getOne não busca a informação no banco de dados, ele instacia um objeto provisório diferente do findbyid que vai buscar a informação no banco
		
		        entity.setName(dto.getName());
		        entity.setCpf(dto.getCpf());
		        entity.setIcome(dto.getIcome());
		        entity.setChildren(dto.getChildren());
		        entity.setBirthDate(dto.getBirthDate());
		
	            entity = repository.save(entity); //Responsável por salvar
	    
	            return new ClientDto(entity);
	    }
	    
	    catch (EntityNotFoundException e) {
	       
	    	throw new MyEntityNotFoundException("Cliente não localizado !!!");
	    
	    }
	   
	}
	
}