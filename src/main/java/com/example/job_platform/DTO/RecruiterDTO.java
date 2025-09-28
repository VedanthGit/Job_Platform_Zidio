package com.example.job_platform.DTO;

import com.example.job_platform.Entity.User;

public class RecruiterDTO {
	public Long id;
	public String recruiterName;
	public String companyName;
	public String recruiterEmail;
	public String recruiterPhone;
	public String designation;
	private String password;
	public User user;
	
	public RecruiterDTO() {}
	public RecruiterDTO(Long id , String recruiterName,String companyName,String recruiterEmail,String  recruiterPhone,String designation, String password, User user ) {
		
		this.id=id;
		this.recruiterName=recruiterName;
		this.companyName=companyName;
		this.recruiterEmail=recruiterEmail;
		this.recruiterPhone=recruiterPhone;
		this.designation=designation;
		this.password=password;
		this.user=user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecruiterName() {
		return recruiterName;
	}
	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getRecruiterEmail() {
		return recruiterEmail;
	}
	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}
	public String getRecruiterPhone() {
		return recruiterPhone;
	}
	public void setRecruiterPhone(String recruiterPhone) {
		this.recruiterPhone = recruiterPhone;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
