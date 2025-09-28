package com.example.job_platform.DTO;

import java.time.LocalDate;

import com.example.job_platform.Enum.JobType;

public class JobPostDTO {
	
	public Long id;
	public Long recruiterId;
	public String companyName;
	public String jobTitle;
	public String jobDescription;
	public String jobLocation;
	public JobType jobType;
	public LocalDate postedDate;
	public LocalDate deadLineDate;
	
	
	public JobPostDTO() {}
	
	public JobPostDTO(Long id,Long recruiterId,String companyName,String jobTitle,JobType jobType,String jobDescription,String jobLocation,LocalDate postedDate,LocalDate deadLineDate) {
		this.id=id;
		this.recruiterId=recruiterId;
		this.companyName=companyName;
		this.jobTitle=jobTitle;
		this.jobDescription=jobDescription;
		this.jobLocation=jobLocation;
		this.jobType=jobType;
		this.postedDate=postedDate;
		this.deadLineDate=deadLineDate;
	}
}
