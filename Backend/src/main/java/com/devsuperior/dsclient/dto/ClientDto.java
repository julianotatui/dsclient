package com.devsuperior.dsclient.dto;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.dsclient.entities.Client;

public class ClientDto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String cpf;
	private double icome;
	private Instant birthDate;
	private int children;
	private Instant logCreated;
	
    public ClientDto() {
		
	  }
	
	
	public ClientDto(long id, String name, String cpf, double icome, Instant birthDate, int children) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.icome = icome;
		this.birthDate = birthDate;
		this.children = children;
	}
	
	//Método para popular e espelhar o ClientDto através do ponteiro  do Client
    public ClientDto(Client Entity) {
    	
    	this.id = Entity.getId();
		this.name = Entity.getName();
		this.cpf = Entity.getCpf();
		this.icome = Entity.getIcome();
		this.birthDate = Entity.getBirthDate();
		this.children = Entity.getChildren();
		this.logCreated = Entity.getLogCreated();
    	
	  }



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getIcome() {
		return icome;
	}

	public void setIcome(double icome) {
		this.icome = icome;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}


	public Instant getLogCreated() {
		return logCreated;
	}



}
