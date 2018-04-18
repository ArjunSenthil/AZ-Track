package com.agile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.model.IssueType;

public interface IssueTypeRepository extends JpaRepository<IssueType,Long>
{
	
}
