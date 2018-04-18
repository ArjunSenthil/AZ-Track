package com.agile.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.agile.dao.IssueTypeRepository;
import com.agile.model.Issue;
import com.agile.model.IssueType;
import com.agile.model.Project;
import com.agile.model.ResponseHandler;
import com.agile.service.IssueServiceImpl;
import com.agile.service.ProjectServiceImpl;
import com.agile.service.UploadServiceImpl;

@CrossOrigin(origins = "http://192.168.5.30:4200")
@Controller		// This means that this class is a Controller.
@RequestMapping(path="/issue")
@ControllerAdvice
public class IssueController 
{
	
	@Autowired
	IssueServiceImpl issueserviceimpl;
	
	@Autowired
	UploadServiceImpl uploadserviceimpl;
	
	@Autowired
	IssueTypeRepository issuetyperepository;
	
	@Autowired
	ProjectServiceImpl projectserviceimpl;
		
	@RequestMapping(path="/add", method=RequestMethod.POST/*, headers="Accept=multipart/form-data"*/)
	@ResponseBody ResponseEntity<?> addNewIssue(@ModelAttribute Issue issue)
	{
		try 
		{
			uploadserviceimpl.saveUploadedFiles(issue.getUploadfile());
		} 
		catch (IOException e) 
		{
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		issue.setFilePath(issue.getUploadfile().getOriginalFilename());
		return issueserviceimpl.addIssue(issue);
	}
	
	@RequestMapping(path="/issuetype",method=RequestMethod.GET)
	@ResponseBody List<IssueType> getIssueTypes()
	{
		return issuetyperepository.findAll();
	}
	
	@RequestMapping(path="/project", method=RequestMethod.GET) 
	@ResponseBody List<Project> getProjectNames()
	{
		return projectserviceimpl.viewProjects();
	}
	
	@RequestMapping(path="/listissue", method=RequestMethod.GET) 
	@ResponseBody List<Issue> getIssue(@RequestParam long id)
	{
		return issueserviceimpl.getIssueById(id);
	}
	
	@RequestMapping(path="/select", method=RequestMethod.GET)
	@ResponseBody Issue viewissueDetails(@RequestParam long id)
	{
		return issueserviceimpl.selectIssue(id);
	}	
	
	@RequestMapping(path="/edit", method=RequestMethod.PUT)
	@ResponseBody ResponseHandler editIssue(@RequestBody Issue issue)
	{
		return issueserviceimpl.editIssue(issue);
	}
	
	@RequestMapping(path="/delete", method=RequestMethod.DELETE)
	@ResponseBody ResponseHandler deleteIssue(@RequestParam long id)
	{
		return issueserviceimpl.deleteIssue(id);
	}

}
