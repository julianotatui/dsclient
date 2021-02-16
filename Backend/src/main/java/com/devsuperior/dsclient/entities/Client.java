package com.devsuperior.dsclient.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String cpf;
	private double icome;
	private Instant birthDate;
	private int children;
	
	public Client() {
		
	}
	
	

	public Client(long id, String name, String cpf, double icome, Instant birthDate, int children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.icome = icome;
		this.birthDate = birthDate;
		this.children = children;
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
	
	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
}
