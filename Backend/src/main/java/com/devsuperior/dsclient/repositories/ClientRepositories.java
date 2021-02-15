package com.devsuperior.dsclient.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsclient.entities.Client;

@Repository
public interface ClientRepositories extends JpaRepository<Client, Long> {

}
