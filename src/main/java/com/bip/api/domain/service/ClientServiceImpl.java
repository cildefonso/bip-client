package com.bip.api.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bip.api.domain.model.Client;
import com.bip.api.domain.repository.ClientRepository;
import com.bip.domain.exception.NegocioException;

@Service
public class ClientServiceImpl  implements ClientService{
	
	private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);
	@Autowired
	private ClientRepository clientRepository;
	private Client userExistente;
	
	public Client insert(Client client) {
		if (!"".equals(client.getCnpj()))
		  userExistente = clientRepository.findByCnpj(client.getCnpj());
		else if (!"".equals(client.getCpf()))
			  userExistente = clientRepository.findByCpf(client.getCpf());
		
		if (userExistente != null && !userExistente.equals(client)) {
			throw new NegocioException("Este cliente encontra-se cadastrada. ");
		}
	
		return clientRepository.save(client);
	}
	
	public Client upDate(Client client) {
		if (!"".equals(client.getCnpj()))
			  userExistente = clientRepository.findByCnpj(client.getCnpj());
			else if (!"".equals(client.getCpf()))
				  userExistente = clientRepository.findByCpf(client.getCpf());
		
		if (userExistente == null && userExistente.equals(client)) {
			throw new NegocioException("Este cliente não está cadastrada. ");
		}
	
		return clientRepository.save(client);
	}

//	public Client list(Client client) {
//		Client objClient = new Client();
//		if (!"".equals(client.getCnpj()))
//			objClient = clientRepository.findByCnpj(client.getCnpj());
//		else if (!"".equals(client.getCpf()))
//			objClient = clientRepository.findByCpf(client.getCpf());
//		
//		if (objClient == null || "".equals(objClient.toString())) {
//			throw new NegocioException("Este cliente não foi encontrado. ");
//		}
//	
//		return objClient;
//	}
	
   public void deletar(Client client) {
	   clientRepository.delete(client);
   }
   
   public List<Client> findAll() {
	  log.info("Buscar todos os clientes. ");
      return clientRepository.findAll();
   }

   public long count() {
       return clientRepository.count();
   }

   public Client findBy_id(String id) {
	   log.info("Buscar todos os clientes. ", id);
	   return clientRepository.findBy_id(id);
	}
	
   public Client findByEmail(String email) {
	   log.info("Buscar todos os clientes. ", email);
	   return clientRepository.findByEmail(email);
	}
	
   public Client findByCnpj(String cnpj) {
	   log.info("Buscar todos os clientes. ", cnpj);
	   return clientRepository.findByCnpj(cnpj);
	}

   public Client findByCpf(String cpf) {
	   log.info("Buscar todos os clientes. ", cpf);
	   return clientRepository.findByCpf(cpf);
	}

}
