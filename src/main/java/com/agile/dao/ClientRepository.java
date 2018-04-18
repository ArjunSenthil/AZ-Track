package com.agile.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agile.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> 
{
	@Query(value="SELECT client FROM Client client WHERE client.isActive=1")
	public List<Client> findAllClients();

	@Query(value="SELECT client FROM Client client WHERE client.id=:id")
	public Client selectOneClient(@Param("id") Long id);

	@Query(value="SELECT client from Client client WHERE client.companyName=:companyName")
	public Client findByName(@Param ("companyName")String companyyName);

}
