package com.bip.api.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bip.api.domain.model.Client;
import com.bip.api.domain.service.ClientService;
/* Teste de stress e performace com Apache Ab
   ab -n 10000 -c 100 http://localhost:8080/api/companymongodb/
*/
import com.bip.api.domain.service.UfCacheService;

@RestController
@EnableCaching
@RequestMapping("/api/client")
public class ClientController {
	
	private static final Logger log = LoggerFactory.getLogger(ClientController.class);
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;
	
	@Autowired
	private UfCacheService ufCacheService;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(value = "/email/{strEmail:.+}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Client> findByEmail(@PathVariable ("strEmail") String strEmail) {
		System.out.println("--------------------------------");
		Client client = clientService.findByEmail(strEmail);
		System.out.println("Informações da empresa "+ client);
		log.info("Informações da empresa "+ client);
		
		System.out.println(this.ufCacheService.lisUfCache());
		if (!(client == null)) {
		   return ResponseEntity.ok(client);
		}
	    
		return ResponseEntity.notFound().build();	 		
	}
	
	@GetMapping(value = "/cnpj/{strCnpj:.+}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Client> findByCnpj(@PathVariable ("strCnpj") String strCnpj) {
		System.out.println("--------------------------------");
		Client client = clientService.findByCnpj(strCnpj);
		System.out.println("Informações da empresa "+ client);
		log.info("Informações da empresa "+ client);
		System.out.println(this.ufCacheService.lisUfCache());
		if (!(client == null)) {
		   return ResponseEntity.ok(client);
		}
	    
		return ResponseEntity.notFound().build();	 		
	}
	
	@GetMapping(value = "/cpf/{strCpf:.+}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Client> findByCpf(@PathVariable ("strCpf") String strCpf) {
		System.out.println("--------------------------------");
		Client client = clientService.findByCnpj(strCpf);
		System.out.println("Informações da empresa "+ client);
		log.info("Informações da empresa "+ client);
		System.out.println(this.ufCacheService.lisUfCache());
		if (!(client == null)) {
		   return ResponseEntity.ok(client);
		}
	    
		return ResponseEntity.notFound().build();	 		
	}
	
	@PostMapping(value = "/", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Client> register(@Valid @RequestBody Client client) {
		if ((client == null )) {
			return ResponseEntity.notFound().build();
		}
		Client clientDB = clientService.insert(client);
		
		return ResponseEntity.ok(clientDB);
	}
	
	@PutMapping(value = "/{strEmail}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Client> change(@Valid @PathVariable ("strEmail") String strEmail, @RequestBody Client client){
		
		if ((client == null )) {
			return ResponseEntity.notFound().build();
		}
		//companyMongoDB.setCnpj(strCnpj);
		Client clientDB = clientService.upDate(client);
		
		
		return ResponseEntity.ok(clientDB);
	}
	
	@DeleteMapping(value = "/{strEmail}", headers = "X-API-Version=v1", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Void> deletar(@PathVariable String strEmail){
		Client client = clientService.findByEmail(strEmail);
		
		if ((client == null)) {
			return ResponseEntity.notFound().build();
			
		}
		clientService.deletar(client);
	
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "email/v4/{strEmail}", produces=MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<Client> buscarV1(@PathVariable ("strEmail") String strEmail) {
		Client clientDB = new Client();
		clientService.findAll().forEach(System.out::println);
		System.out.println();
	
		System.out.println("--------------------------------");
		//userRepository.findByNumberAddressBetween(18, 90).forEach(System.out::println);
		System.out.println("--------------------------------");
		
		System.out.println("Executando serviço pela primeira vez: ");
		System.out.println(this.ufCacheService.lisUfCache());
		
		System.out.println("Executando serviço pela segunda vez, deve obter dados do cache: ");
		System.out.println(this.ufCacheService.lisUfCache());
	    
	    return ResponseEntity.ok(clientDB);	
	}
	
	

}
