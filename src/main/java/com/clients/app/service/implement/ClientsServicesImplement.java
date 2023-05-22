package com.clients.app.service.implement;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clients.app.entity.ClientsEntity;
import com.clients.app.repository.ClientsRepository;
import com.clients.app.service.ClientsService;

@Service
public class ClientsServicesImplement implements ClientsService {
	
	@Autowired
	ClientsRepository repo;
	@Override
	public ClientsEntity findBySharedKey(String sharedKey) {
		Optional<ClientsEntity> clientTem = repo.findBySharedKey(sharedKey);
		ClientsEntity client = clientTem.get();
		return client;
	}
	@Override
	public ClientsEntity saveClient(ClientsEntity clientsEntity) {
		String[] divs = clientsEntity.getBusinessId().split(" ");
        StringBuilder sharedKey = new StringBuilder();
        for (String div : divs) {
            if (!div.isEmpty()) {
                sharedKey.append(Character.toLowerCase(div.charAt(0)));
            }
        }
        sharedKey.append(divs[divs.length - 1].substring(1).toLowerCase());
        clientsEntity.setDataAdd(new Date());
        clientsEntity.setSharedKey(sharedKey.toString());
        return repo.save(clientsEntity);
	}
	
	@Override
	public List<ClientsEntity> readClients() {
		return repo.findAll();
	}
	@Override
	public ClientsEntity updateClient(ClientsEntity clientsEntity) {
		ClientsEntity clientByShared = findBySharedKey(clientsEntity.getSharedKey());
		clientByShared.setBusinessId(clientsEntity.getBusinessId());
		clientByShared.setPhone(clientsEntity.getPhone());
		clientByShared.setEmail(clientsEntity.getEmail());
		clientByShared.setStartDate(clientsEntity.getStartDate());
		clientByShared.setEndDate(clientsEntity.getEndDate());
		clientByShared.setDataAdd(new Date());
		
		return repo.save(clientByShared);
	}
	@Override
	public String deleteBySharedKey(String sharedKey) {
		repo.deleteById(sharedKey);
		return "";
	}
	

}
