package com.bip.api.domain.repository;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bip.api.domain.model.Client;


// No need implementation, just one interface, and you have CRUD, thanks Spring Data
//https://www.mballem.com/post/nosql-com-mongodb-e-persistencia-em-java/
public interface ClientRepository extends MongoRepository<Client, String> {

	
	Client findBy_id(String id);
	Client findByEmail(String email);
	Client findByCnpj(String cnpj);
	Client findByCpf(String cpf);
	//Client list(Client client);

}
