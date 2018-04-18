package com.agile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.agile.dao.IssueRepository;
import com.agile.dao.IssueTypeRepository;
import com.agile.dao.ProjectRepository;
import com.agile.model.Issue;
import com.agile.model.ResponseHandler;

import Exception.ResourceAlreadyExistsException;
import Exception.ResourceNotFoundException;

@Service
public class IssueServiceImpl implements IssueService
{
	
	@Autowired
	IssueRepository issuerepository;
	
	@Autowired
	IssueTypeRepository issuetyperepository;
	
	@Autowired
	ProjectRepository projectrepository;
	
	@Override
	public ResponseEntity<?> addIssue(Issue issue)
	{	
		if(issuerepository.findByName(issue.getTitle()) != null)
				throw new ResourceAlreadyExistsException(issue.getId(),"Issue Already found with the same name.");
		issue.setActive(true);
		issuerepository.save(issue);
		issue.setIssuetype(issuetyperepository.findOne(issue.getIssuetypeId()));
		issue.setProject(projectrepository.findOne(issue.getProjectId()));
		return new ResponseEntity("Successfully added issue!", HttpStatus.OK);
	}
	
	@Override
	public List<Issue> getIssueById(long projectId)
	{
		if(issuerepository.findbyprojid(projectId)!=null)
			return issuerepository.findbyprojid(projectId);
		else 
			throw new ResourceNotFoundException(projectId,"No issues found for the selected project");
		
	}

	@Override
	public ResponseHandler editIssue(Issue issue)
	{
		if(issuerepository.findByName(issue.getTitle()).getId() != issue.getId())
			throw new ResourceAlreadyExistsException(issue.getId(),"Issue Already found with the same name.");
		Issue preissue=issuerepository.findOne(issue.getId());
		if(preissue!=null) issue.setId(preissue.getId());
		issue.setActive(true);
		issuerepository.save(issue);
		return new ResponseHandler(issue,HttpStatus.OK,"Issue Updated successfully.....!!!!!");
	}

	@Override
	public ResponseHandler deleteIssue(long id) 
	{
		issuerepository.findOne(id).setActive(false);
		issuerepository.save(issuerepository.findOne(id));
		return new ResponseHandler(HttpStatus.OK,"Selected issue deleted successfully.....!!!!!");
	}

	@Override
	public Issue selectIssue(long id) {
		return issuerepository.findOne(id);

	}


}
