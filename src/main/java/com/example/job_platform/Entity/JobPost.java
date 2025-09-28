package com.example.job_platform.Entity;

import java.time.LocalDate;

import com.example.job_platform.Enum.JobType;

import javax.persistence.*;

@Entity
@Table(name="jobPosts")
public class JobPost {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String jobTitle;
	private String companyName;
	private String jobLocation;
	private JobType jobType;
	private String jobDescription;
	private LocalDate postedDate;
	private LocalDate deadLineDate;
	private Long recruiterId;
	private String recruiterEmail;
	public Long getId() {
		return id;
	}
	
	public JobPost() {}
	public JobPost(Long id, String jobTitle, String companyName, String jobLocation, JobType jobType, String jobDescription,String recruiterEmail,LocalDate postedDate,LocalDate deadLineDate,Long recruiterId) {
		this.id=id;
		this.jobTitle=jobTitle;
		this.companyName=companyName;
		this.jobDescription=jobDescription;
		this.jobLocation=jobLocation;
		this.jobType=jobType;
		this.deadLineDate=deadLineDate;
		this.postedDate=postedDate;
		this.recruiterId=recruiterId;
		this.recruiterEmail=recruiterEmail;
		
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public LocalDate getDeadLineDate() {
		return deadLineDate;
	}

	public void setDeadLineDate(LocalDate deadLineDate) {
		this.deadLineDate = deadLineDate;
	}

	public Long getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getRecruiterEmail() {
		return recruiterEmail;
	}

	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
