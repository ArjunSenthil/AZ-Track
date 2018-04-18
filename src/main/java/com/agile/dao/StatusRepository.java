package com.agile.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.model.Status;

public interface StatusRepository extends JpaRepository<Status,Long>
{

}
