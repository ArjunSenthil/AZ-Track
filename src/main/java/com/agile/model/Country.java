package com.agile.model;

import javax.persistence.*;

@Entity
@Table(name="country")
public class Country 
{
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String iso;
    
    private String countryName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
