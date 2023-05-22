package com.clients.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clients.app.entity.ClientsEntity;

@Repository
public interface ClientsRepository extends JpaRepository<ClientsEntity, String>{
	
	
	Optional<ClientsEntity> findBySharedKey(String sharedKey);
	
	
}
