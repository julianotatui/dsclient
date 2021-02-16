package com.devsuperior.dsclient.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsclient.dto.ClientDto;
import com.devsuperior.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResources {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<ClientDto>> findAll(){
     
		List<ClientDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	

}
