package com.agile.model;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="worklog")
public class Worklog 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="worklogId")
	private long id;
	
	@OneToOne
	@JoinColumn(name="projectId",updatable=false,insertable=false)
	private Project project;
	
	private long projectId;
	
	@OneToOne
	@JoinColumn(name="issueId",updatable=false,insertable=false)
	private Issue issue;
	
	private long issueId;
	
	private long realEstimation;
	
	private long workedHours;
	
	private String comments;
	
	@OneToOne
	@JoinColumn(name="statusId",updatable=false,insertable=false)
	private Status status;
	
	private long statusId;
	
	@Transient
	private MultipartFile uploadfile;
	
	private String filePath;
	
	private boolean isActive;
    
    public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(long workedHours) {
		this.workedHours = workedHours;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public long getRealEstimation() {
		return realEstimation;
	}

	public void setRealEstimation(long realEstimation) {
		this.realEstimation = realEstimation;
	}

	public MultipartFile getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(MultipartFile uploadfile) {
		this.uploadfile = uploadfile;
	}
	
	
	
}
