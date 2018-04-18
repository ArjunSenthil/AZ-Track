package com.agile.model;

import javax.persistence.*;

@Entity
@Table(name="contactPerson")
public class ContactPerson
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="contactId")
	private long id;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="contactId",referencedColumnName="clientId")
	private Client client;
	
	private String name;
	
	private String responsible;
	
	private Double phoneNumber;

	private String email;
	
	public ContactPerson setClient(Client client)
	{
		this.client=client;
		return this;
	}
	public long getId() {
		return id;
	}

	public ContactPerson setId(long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public ContactPerson setName(String name) {
		this.name = name;
		return this;
	}

	public String getResponsible() {
		return responsible;
	}

	public ContactPerson setResponsible(String responsible) {
		this.responsible = responsible;
		return this;
	}

	public Double getPhoneNumber() {
		return phoneNumber;
	}

	public ContactPerson setPhoneNumber(Double phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public ContactPerson setEmail(String email) {
		this.email = email;
		return this;
	}
}
