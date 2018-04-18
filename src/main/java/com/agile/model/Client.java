package com.agile.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.agile.model.ContactPerson;

@Entity
@Table(name="client")
public class Client implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="clientId")
	private long id;

	private String companyName;
    
    private String address;

    private String email;
    
    private Double phoneNumber;
    
    private boolean isActive;
    
    @OneToOne
	@JoinColumn(name="countryId", insertable=false ,updatable=false)
    private Country country;
    
    private long countryId;    

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="clientId",referencedColumnName="clientId")
    private Set<ContactPerson> contactPersons;
        
    public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

    public Set<ContactPerson> getContactPerson() {
		return contactPersons;
	}
  
	public void setContactPerson(Set<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}

	public long getId() {
        return id;
    }
     
	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
