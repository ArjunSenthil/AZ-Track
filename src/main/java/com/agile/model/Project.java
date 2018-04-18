package com.agile.model;

import javax.persistence.*;


@Entity
@Table(name="project")
public class Project
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="projectId")
	private long id;
	
	private String projectName;
	
	private String description;
	
	@OneToOne
	@JoinColumn(name="clientId", insertable=false, updatable=false)
	private Client client;
	
	private long clientId;
	
	private boolean isActive;
    
    public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	
}
