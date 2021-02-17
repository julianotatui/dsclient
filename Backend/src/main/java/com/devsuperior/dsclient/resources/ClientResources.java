package com.devsuperior.dsclient.resources;

import java.net.URI;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dsclient.dto.ClientDto;
import com.devsuperior.dsclient.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResources {

	@Autowired
	private ClientService service;

	/* Lista os clientes sem paginação
	@GetMapping
	public ResponseEntity<List<ClientDto>> findAll()
	{
     
		List<ClientDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	*/
	
	/* lista os clientes com paginação */
	@GetMapping
	public ResponseEntity<Page<ClientDto>> findAll(	@RequestParam(value = "page", defaultValue = "0") Integer page,
			                                        @RequestParam(value = "linesPerPage", defaultValue = "3") Integer linesPerPage,
			                                        @RequestParam(value = "direction", defaultValue = "ASC") String direction,
			                                        @RequestParam(value = "orderBy", defaultValue = "name") String orderBy)
	    {
     
		     PageRequest pageRequest = PageRequest.of(page, linesPerPage, org.springframework.data.domain.Sort.Direction.valueOf(direction), orderBy);
		     Page<ClientDto> list = service.findAllPaged(pageRequest);
		     return ResponseEntity.ok().body(list);
	    }
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDto> findById(@PathVariable long  id){
     	ClientDto dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ClientDto> insert(@RequestBody ClientDto dto){
     	dto = service.insert(dto);
     	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();  //responsável por trocar o retorno 200 para 201 (criado com sucesso)
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDto> update(@PathVariable long  id, @RequestBody ClientDto dto){
     	dto = service.update(id, dto);
     	return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClientDto> update(@PathVariable long  id){
     	service.delete(id);
     	return ResponseEntity.noContent().build(); //resposta 204 ==> e não tem corpo na resposta.
	}
	

}
