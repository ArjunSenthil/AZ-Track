package com.agile.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agile.model.Worklog;

public interface WorklogRepository extends JpaRepository<Worklog,Long>
{
	@Query(value="SELECT worklog FROM Worklog worklog WHERE worklog.projectId=:id")
	public List<Worklog> findById(@Param ("id") long id);

	@Query(value="SELECT sum(worklog.workedHours) FROM Worklog worklog WHERE worklog.projectId=:id")
	public long getAllWorkedHours(@Param ("id") long id);	
}

