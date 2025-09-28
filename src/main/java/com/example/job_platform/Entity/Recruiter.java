package com.example.job_platform.Entity;

import javax.persistence.*;

@Entity
@Table(name="recruiters")
public class Recruiter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id;
	private String recruiterName;
	private String companyName;
	private String recruiterEmail;
	private String recruiterPhone;
	private String designation;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	private String password;
    
	public Recruiter() {}
	public Recruiter(Long id,String recruiterName,String companyName,String recruiterEmail,String recruiterPhone, String designation, User user, String password  ) {
		
		this.id = id;
		this.recruiterName=recruiterName;
		this.companyName=companyName;
		this.recruiterPhone=recruiterPhone;
		this.recruiterEmail=recruiterEmail;
		this.designation=designation;
		this.user=user;
		this.password=password;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
