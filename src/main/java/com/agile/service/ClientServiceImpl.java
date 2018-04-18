package com.agile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.agile.dao.ClientRepository;
import com.agile.dao.CountryRepository;
import com.agile.model.Client;
import com.agile.model.ResponseHandler;

import Exception.ResourceAlreadyExistsException;
import Exception.ResourceNotFoundException;

@Service			//This indicates that the class acts as a service.
public class ClientServiceImpl implements ClientService
{
	
	@Autowired			//Injects object dependency implicitly.
	private ClientRepository clientrepository;
	
	@Autowired			//Injects object dependency implicitly.
	private CountryRepository countryrepository;
	

	 @Override			//The following method has the same name, number and type of parameters,and return type as the method that it overrides.
	public ResponseHandler addClient(Client client)
	 {	
			if(clientrepository.findByName(client.getCompanyName()) != null)
				throw new ResourceAlreadyExistsException(client.getId(),"Client Already found with the same name.");
			client.setActive(true);
			clientrepository.save(client);
			client.setCountry(countryrepository.findOne(client.getCountryId()));
			return new ResponseHandler(client,HttpStatus.OK,"Client Successfully Added!!!!!");
	}
	 
	 @Override
	public List<Client> viewAllClients() 
		{
		 	return clientrepository.findAllClients();
		}
	
	@Override			//The following method has the same name, number and type of parameters,and return type as the method that it overrides.
	public List<Client> viewClients()
	{
		if(clientrepository.findAllClients().size()!=0)
			return clientrepository.findAllClients();
		else
			throw new ResourceNotFoundException(0L,"No Clients foundS");
	}
	
	@Override			//The following method has the same name, number and type of parameters,and return type as the method that it overrides.
	public Client selectClient(Long a) 
	{
		if(clientrepository.exists(a))
			return clientrepository.selectOneClient(a);
		else
			throw new ResourceNotFoundException(a,"No Such Client id Found.");
	}
	
	@Override			//The following method has the same name, number and type of parameters,and return type as the method that it overrides.
	public ResponseHandler deleteClient(Long a)
	{
		clientrepository.findOne(a).setActive(false);
		clientrepository.save(clientrepository.findOne(a));
		return new ResponseHandler(HttpStatus.OK,"Selected Client Deleted......!!!!!");
	}
	
	@Override
	public ResponseHandler editClient(Client client)
	{
		if(clientrepository.findByName(client.getCompanyName()).getId() != client.getId())
			throw new ResourceAlreadyExistsException(client.getId(),"Client Already found with the same name.");
		Client preclient=clientrepository.findOne(client.getId());
		if(preclient!=null) client.setId(preclient.getId());
		client.setActive(true);
		clientrepository.save(client);
		return new ResponseHandler(client,HttpStatus.OK,"Client Updated successfully.......!!!!!");
}
}
