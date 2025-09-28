package com.example.job_platform.Entity;

import javax.persistence.*;

import com.example.job_platform.Enum.Status;


@Entity
@Table(name="applications")
public class Application {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long jobId;
	private String employeeEmail;
	private String recruiterEmail;
	private String resumeURL;
	private Status status;
	
	public Application() {}
	public Application(Long id, Long jobId, String employeeEmail,String recruiterEmail,String resumeURL, Status status) {
		this.id=id;
		this.jobId=jobId;
		this.employeeEmail=employeeEmail;
		this.recruiterEmail=recruiterEmail;
		this.status=status;
		this.resumeURL=resumeURL;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getResumeURL() {
		return resumeURL;
	}
	public void setResumeURL(String resumeURL) {
		this.resumeURL = resumeURL;
	}
	
	
}
