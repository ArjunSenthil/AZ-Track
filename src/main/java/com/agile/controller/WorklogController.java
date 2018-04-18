package com.agile.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agile.model.Project;
import com.agile.model.ResponseHandler;
import com.agile.model.Status;
import com.agile.model.Worklog;
import com.agile.service.*;

import Exception.ResourceAlreadyExistsException;

@CrossOrigin(origins = "http://192.168.5.30:4200")
@Controller		// This means that this class is a Controller.
@RequestMapping(path="/worklog")
@ControllerAdvice
public class WorklogController 
{
	@Autowired
	WorklogServiceImpl worklogserviceimpl;
	
	@Autowired
	ProjectServiceImpl projectserviceimpl;
	
	@Autowired
	IssueServiceImpl issueserviceimpl;
	
	@Autowired 
	UploadServiceImpl uploadserviceimpl;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody ResponseHandler addWorklog(@RequestBody Worklog worklog) throws ResourceAlreadyExistsException
	{
		try 
		{
			uploadserviceimpl.saveUploadedFiles(worklog.getUploadfile());
		} 
		catch (IOException e) 
		{
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		worklog.setFilePath(worklog.getUploadfile().getOriginalFilename());
		return worklogserviceimpl.addworklog(worklog);
		}
	
	@RequestMapping(value="/status", method=RequestMethod.GET)
	@ResponseBody List<Status> getAllStatus()
	{
		return worklogserviceimpl.getStatus();
	}
	
	@RequestMapping(value="/project" ,method=RequestMethod.GET)
	@ResponseBody List<Project> getProjectNames()
	{
		return projectserviceimpl.viewProjects();
	}
	
	@RequestMapping(value="/estimatedtime", method=RequestMethod.GET)
	@ResponseBody Worklog getIssueId(@RequestParam long issueId)
	{
		return worklogserviceimpl.getTimeEstimation(issueId);
	}

	@RequestMapping(value="/select", method=RequestMethod.GET) 
	@ResponseBody List<Worklog> getWorklog(@RequestParam long id)
	{
		return worklogserviceimpl.getWorklog(id);
	}

}
