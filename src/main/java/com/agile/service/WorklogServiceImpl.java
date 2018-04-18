package com.agile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.agile.dao.WorklogRepository;
import com.agile.dao.IssueRepository;
import com.agile.dao.ProjectRepository;
import com.agile.dao.StatusRepository;
import com.agile.model.ResponseHandler;
import com.agile.model.Status;
import com.agile.model.Worklog;

import Exception.ResourceNotFoundException;

@Service
public class WorklogServiceImpl implements WorklogService
{

	@Autowired
	WorklogRepository worklogrepository;

	@Autowired
	StatusRepository statusrepository;
	
	@Autowired
	IssueRepository issuerepository;

	@Autowired
	ProjectRepository projectrepository;
	
	@Override
	public ResponseHandler addworklog(Worklog worklog) 
	{
		worklog.setActive(true);
		worklogrepository.save(worklog);
		worklog.setIssue(issuerepository.findOne(worklog.getIssueId()));
		worklog.setProject(projectrepository.findOne(worklog.getProjectId()));
		worklog.setStatus(statusrepository.findOne(worklog.getStatusId()));
		return new ResponseHandler(worklog,HttpStatus.OK,"Worklog Successfully Added.....!!!!!");
	}

	@Override
	public List<Status> getStatus() 
	{
		return statusrepository.findAll();
	}

	@Override
	public Worklog getTimeEstimation(long id)
	{
		Worklog worklog =new Worklog();
		if(worklogrepository.findById(id).isEmpty())
		{
			worklog.setRealEstimation(issuerepository.findOne(id).getRealEstimation());
			worklog.setWorkedHours(0);
			return worklog;
		}
		else
		{
			worklog.setRealEstimation(issuerepository.findOne(id).getRealEstimation());
			worklog.setWorkedHours(worklogrepository.getAllWorkedHours(id));
			return worklog;
		}
	}

	@Override
	public List<Worklog> getWorklog(long id) 
	{
		if(worklogrepository.findById(id)!=null)
			return worklogrepository.findById(id);
		else
			throw new ResourceNotFoundException(id,"No worklogs found for the selected issue");
	}
}
