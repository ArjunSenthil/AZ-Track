package com.agile.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.agile.dao.ClientRepository;
import com.agile.dao.ProjectRepository;
import com.agile.model.Client;
import com.agile.model.Project;
import com.agile.model.ResponseHandler;

import Exception.ResourceAlreadyExistsException;
import Exception.ResourceNotFoundException;

@Service			//ProjectServiceImpl class acts a service.And implements ProjectService interface.
public class ProjectServiceImpl implements ProjectService
{
	
	@Autowired			//Injects ProjectRepository dependency implicitly.
	private ProjectRepository projectrepository;
	
	@Autowired			//Injects ClientRepository dependency implicitly.
	private ClientRepository clientrepository;

		
	@Override			//The addProject method overrides the addProject method by requesting repository to save the received parameter.
	public ResponseHandler addProject(Project project) 
	{		
		if(projectrepository.findByName(project.getProjectName()) != null)
			throw new ResourceAlreadyExistsException(project.getId(),"Project Already found with the same name.");
		project.setActive(true);
		projectrepository.save(project);
		project.setClient(clientrepository.findOne(project.getId()));;
		return new ResponseHandler(project,HttpStatus.OK,"Project Successfully Added!!!!!");
	}

	@Override			//The getClientList method overrides te getClientList method by requesting repository to return all clients' names.
	public List<Client> getClientList() 
	{
		return clientrepository.findAllClients();
	}

	@Override
	public List<Project> viewProjects()
	{
		if(projectrepository.findAllProjects().size()!=0)
			return projectrepository.findAllProjects();
		else
			throw new ResourceNotFoundException(0L,"No projects found.");
	}

	@Override
	public Project selectProject(long id) 
	{
		return projectrepository.findOne(id);
	}

	@Override
	public ResponseHandler deleteProject(long id) 
	{
		projectrepository.findOne(id).setActive(false);
		projectrepository.save(projectrepository.findOne(id));
		return new ResponseHandler(HttpStatus.OK,"Selected project deleted successfully.....!!!!!");
	}

	@Override
	public ResponseHandler editProject(Project project) 
	{
		if(projectrepository.findByName(project.getProjectName()).getId() != project.getId())
			throw new ResourceAlreadyExistsException(project.getId(),"Project Already found with the same name.");
		Project preproject=projectrepository.findOne(project.getId());
		if(preproject!=null) project.setId(preproject.getId());
		project.setActive(true);
		projectrepository.save(project);
		return new ResponseHandler(project,HttpStatus.OK,"Project Updated successfully.....!!!!!");
	}

}