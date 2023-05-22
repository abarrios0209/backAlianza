package com.clients.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clients.app.entity.ClientsEntity;
import com.clients.app.service.ClientsService;

@RestController
@RequestMapping("/clients/")
public class ClientsController {
	
	@Autowired
	ClientsService clientsService;
	
	@GetMapping(path= "findBySharedKey", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findBySharedKey(@RequestParam ("sharedKey") String sharedKey) {
        try {
            return ResponseEntity.ok(clientsService.findBySharedKey(sharedKey));
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
	}
	
	@PostMapping(path="saveClient", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveClient(@RequestBody ClientsEntity clientsEntity){
		try {
            return ResponseEntity.ok(clientsService.saveClient(clientsEntity));
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
		
	}
	
	@GetMapping(path="readAllClients", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readAllClients(){
		try {
			return ResponseEntity.ok(clientsService.readClients());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
	}
	
	@PutMapping(path="updateClient", consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateClient(@RequestBody ClientsEntity clientsEntity){
		try {
            return ResponseEntity.ok(clientsService.updateClient(clientsEntity));
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
	}
	
	@DeleteMapping(path="deleteClient")
	public ResponseEntity<?> deleteClient(@RequestParam ("sharedKey") String sharedKey){
		try {
            return ResponseEntity.ok(clientsService.deleteBySharedKey(sharedKey));
        } catch (Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
	}
}
