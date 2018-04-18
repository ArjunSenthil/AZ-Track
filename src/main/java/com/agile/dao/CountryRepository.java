package com.agile.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.model.Country;

public interface CountryRepository extends JpaRepository<Country,Long>
{
	@Query(value="SELECT countryName FROM Country")
	List<String> showCountries();
	
	@Query(value="SELECT country from Country country WHERE country.countryName=:countryName")
	Country findByName(@Param ("countryName")String countryName);

}
