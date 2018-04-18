package com.agile.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agile.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>
{
	@Query(value="SELECT project FROM Project project WHERE project.isActive=1")
	public List<Project> findAllProjects();

	@Query(value="SELECT project FROM Project project WHERE project.projectName=:projectName")
	Project findByName(@Param ("projectName")String projectName);
	
}