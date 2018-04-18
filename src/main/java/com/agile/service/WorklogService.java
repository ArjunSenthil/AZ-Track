package com.agile.service;

import java.util.List;

import com.agile.model.ResponseHandler;
import com.agile.model.Status;
import com.agile.model.Worklog;

public interface WorklogService 
{

	public ResponseHandler addworklog(Worklog worklog);

	public List<Status> getStatus();

	public List<Worklog> getWorklog(long id);

	public Worklog getTimeEstimation(long id);

}
