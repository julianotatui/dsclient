package com.devsuperior.dsclient.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsclient.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResources {
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = new ArrayList<>();
		list.add(new Client(1L,"Juliano","31071059882",3.10,Instant.now(),1));
		list.add(new Client(2L,"Maria","890059882",3.10,Instant.now(),2));
		list.add(new Client(3L,"Jose","939259882",3.10,Instant.now(),3));
		list.add(new Client(4L,"Joao","39227259882",3.10,Instant.parse("2017-02-03T11:25:30.00Z"),4));
		list.add(new Client(5L,"Antonio","999999",3.10,Instant.parse("2017-02-03T11:25:30.00Z"),5));
		
		return ResponseEntity.ok().body(list);
	}
	
	

}
