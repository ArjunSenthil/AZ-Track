package com.agile.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agile.model.Issue;

public interface IssueRepository extends JpaRepository<Issue,Long>
{
	@Query(value="SELECT realEstimation FROM Issue issue WHERE issue.id=:id")
	public Integer getWorkTime(@Param ("id") long id);

	@Query(value="SELECT issue FROM Issue issue WHERE issue.title=:title")
	public Issue findByName(@Param ("title")String title);

	@Query(value="SELECT issue FROM Issue issue WHERE issue.projectId=:projectId AND issue.isActive=1")
	public List<Issue> findbyprojid(@Param ("projectId") long projectId);

}
