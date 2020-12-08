package com.bip.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bip.api.domain.model.Client;

@Service
public interface ClientService {

	
	Client insert(Client client);
	Client upDate(Client client);
	void deletar(Client client);   
    long count();
    List<Client> findAll(); 
	Client findBy_id(String id);
	Client findByEmail(String email);
	Client findByCnpj(String cnpj);
	Client findByCpf(String cpf);
	//Client list(Client client);

}
