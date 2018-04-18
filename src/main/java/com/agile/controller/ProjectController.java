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
import com.agile.model.Project;
import com.agile.model.ResponseHandler;
import com.agile.service.ProjectServiceImpl;

@CrossOrigin(origins = "http://192.168.5.30:4200")
@Controller		// This means that this class is a Controller.
@RequestMapping(path="/project")
@ControllerAdvice
public class ProjectController 
{
	
	@Autowired		//Injects object dependency implicitly.
	ProjectServiceImpl projectserviceimpl;

	@RequestMapping(path="/clientlist", method=RequestMethod.GET)
	@ResponseBody List<Client> getClientNames()
	{
		return projectserviceimpl.getClientList();
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	@ResponseBody ResponseHandler addNewProject (@RequestBody Project project)
	{
		return projectserviceimpl.addProject(project);
	}
		
	@RequestMapping(path="/view", method=RequestMethod.GET)
	@ResponseBody List<Project> viewAllProjects ()
	{
		return projectserviceimpl.viewProjects();
	}
	
	
	@RequestMapping(path="/select", method=RequestMethod.GET)
	@ResponseBody Project viewProjectDetails(@RequestParam long id)
	{
		return projectserviceimpl.selectProject(id);
	}	
	
	@RequestMapping(path="/edit", method=RequestMethod.PUT)
	@ResponseBody ResponseHandler editProject(@RequestBody Project project)
	{
		return projectserviceimpl.editProject(project);
	}
	
	@RequestMapping(path="/delete", method=RequestMethod.DELETE)
	@ResponseBody ResponseHandler deleteProject(@RequestParam long id)
	{
		return projectserviceimpl.deleteProject(id);
	}
}
