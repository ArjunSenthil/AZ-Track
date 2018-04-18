package com.agile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.agile.dao.CountryRepository;
import com.agile.model.Country;
import com.agile.model.ResponseHandler;

import Exception.ResourceAlreadyExistsException;

@Service			//This Annotation the class is a service.
public class CountryServiceImpl implements CountryService 
{

	@Autowired			//Injects object dependency implicitly.
	private CountryRepository countryrepository;

	@Override			//The following method has the same name, number and type of parameters,and return type as the method that it overrides.
	public List<Country> showAllCountries() 
	{
		return countryrepository.findAll();
	}
	
	@Override
	public ResponseHandler addMoreCountries(Country country) 
	{
	   if(countryrepository.findByName(country.getCountryName())!=null)
		   throw new ResourceAlreadyExistsException(country.getId(),"Country Already Exists with the same name.");
	   countryrepository.save(country);
		return new ResponseHandler(country,HttpStatus.OK,"Country Successfully Added!!!!!");
	}

}
