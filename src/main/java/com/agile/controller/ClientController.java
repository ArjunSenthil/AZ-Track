package com.agile.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.agile.model.Client;
import com.agile.model.ResponseHandler;
import com.agile.service.ClientServiceImpl;

@CrossOrigin(origins = "http://192.168.5.30:4200")
@Controller    // This means that this class is a Controller.
@RequestMapping(path="/client")
@ControllerAdvice
public class ClientController
{
	
	@Autowired		//Injects object dependency implicitly.
	ClientServiceImpl clientserviceimpl;

	@RequestMapping(path="/add", method=RequestMethod.POST)
	@ResponseBody ResponseHandler addNewClient(@RequestBody Client c)
	{
		return clientserviceimpl.addClient(c);
	}	
	
	@RequestMapping(path="/view", method=RequestMethod.GET) 
	@ResponseBody List<Client> viewClientDtetails()
	{
		return clientserviceimpl.viewClients();
	}
	
	@RequestMapping(path="/select", method=RequestMethod.GET)
	@ResponseBody Client viewClientDetails(@RequestParam long id)
	{
		return clientserviceimpl.selectClient(id);
	}	
	
	@RequestMapping(path="/delete", method=RequestMethod.DELETE)
	@ResponseBody ResponseHandler deleteClient(@RequestParam long id)
	{
		return clientserviceimpl.deleteClient(id);
	}
	
	@RequestMapping(path="/edit", method=RequestMethod.PUT)
	@ResponseBody ResponseHandler editClientDtetails(@RequestBody Client client)
	{
		return clientserviceimpl.editClient(client);
	}
}
