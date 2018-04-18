package com.agile.model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="issue")
public class Issue 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="issueId")
	private long id;
	
	@OneToOne
	@JoinColumn(name="issuetypeId", insertable=false ,updatable=false)
	private IssueType issuetype;
	
	private long issuetypeId;

	private String title;

	private String description;
	
	private long realEstimation;
	
	@OneToOne
	@JoinColumn(name="projectId", insertable=false ,updatable=false)
	private Project project;
	
	private long projectId;
	
	private String filePath;
	
	@Transient
	private MultipartFile uploadfile;

	private boolean isActive;
    
    public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
		
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public IssueType getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(IssueType issuetype) {
		this.issuetype = issuetype;
	}

	public long getIssuetypeId() {
		return issuetypeId;
	}

	public void setIssuetypeId(long issuetypeId) {
		this.issuetypeId = issuetypeId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getRealEstimation() {
		return realEstimation;
	}

	public void setRealEstimation(long realEstimation) {
		this.realEstimation = realEstimation;
	}
	
	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	
	
	
}
