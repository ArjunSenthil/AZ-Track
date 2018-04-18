package com.agile.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.agile.model.Issue;
import com.agile.model.ResponseHandler;

public interface IssueService 
{

	public ResponseEntity<?> addIssue(Issue issue);

	public ResponseHandler deleteIssue(long id);

	public List<Issue> getIssueById(long projectId);

	public ResponseHandler editIssue(Issue issue);

	public Issue selectIssue(long id);	
}
