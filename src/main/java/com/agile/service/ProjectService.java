package com.agile.service;

import java.util.List;

import com.agile.model.Client;
import com.agile.model.Project;
import com.agile.model.ResponseHandler;

public interface ProjectService 
{

	public ResponseHandler addProject(Project pro);	
	
	public List<Client> getClientList();

	public List<Project> viewProjects();

	public Project selectProject(long id);

	public ResponseHandler deleteProject(long id);

	public ResponseHandler editProject(Project project);

}
