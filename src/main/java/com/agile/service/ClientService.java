package com.agile.service;

import java.util.List;

import com.agile.model.Client;
import com.agile.model.ResponseHandler;

public interface ClientService
{
	
	public ResponseHandler addClient(Client com);
	
	public List<Client> viewClients();
	
	public Client selectClient(Long a); 
	
	public List<Client> viewAllClients();

	public ResponseHandler editClient(Client client);

	ResponseHandler deleteClient(Long a);
	
}
