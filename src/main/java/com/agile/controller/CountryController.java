package com.agile.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.agile.model.Country;
import com.agile.model.ResponseHandler;
import com.agile.service.CountryServiceImpl;

@CrossOrigin(origins = "http://192.168.5.30:4200")
@Controller		// This means that this class is a Controller.
@RequestMapping(path="/country")
@ControllerAdvice
public class CountryController 
{

	@Autowired		//Injects object dependency implicitly.
	CountryServiceImpl countryserviceimpl;

	@RequestMapping(path="/view",method=RequestMethod.GET)
	@ResponseBody public List<Country> showAllCountries()
	{
		return countryserviceimpl.showAllCountries();
	}

	@RequestMapping(path="/add",method=RequestMethod.POST)
	@ResponseBody public ResponseHandler addNewCountries(@RequestBody Country country)
	{
		return countryserviceimpl.addMoreCountries(country); 
	}
}
