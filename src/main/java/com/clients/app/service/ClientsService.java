package com.clients.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clients.app.entity.ClientsEntity;

@Service
public interface ClientsService {
	
	@Qualifier(value = "ClientsServicesImplement")
	public ClientsEntity findBySharedKey(String sharedKey);
	
	@Qualifier(value = "ClientsServicesImplement")
	public ClientsEntity saveClient(ClientsEntity clientsEntity);
	
	@Qualifier(value = "ClientsServicesImplement")
	public List<ClientsEntity> readClients();
	
	@Qualifier(value = "ClientsServicesImplement")
	public ClientsEntity updateClient(ClientsEntity clientsEntity);
	
	@Qualifier(value = "ClientsServicesImplement")
	public String deleteBySharedKey(String sharedKey);
}
