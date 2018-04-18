package com.agile.service;

import java.util.List;

import com.agile.model.Country;
import com.agile.model.ResponseHandler;

public interface CountryService
{
	public List<Country> showAllCountries();

	public ResponseHandler addMoreCountries(Country newcountry);

}
