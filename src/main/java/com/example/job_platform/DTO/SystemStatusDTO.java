package com.example.job_platform.DTO;

public class SystemStatusDTO {

	public int totalUsers;
	public int totalRecruiters;
	public int totalEmployees;
	public int totalJobPost;
	public int totalApplications;
	
	public SystemStatusDTO() {}
	public SystemStatusDTO( int totalUsers,int totalRecruiters,int totalEmployees,int totalJobPost,int totalApplications) {
		this.totalUsers=totalUsers;
		this.totalRecruiters=totalRecruiters;
		this.totalEmployees=totalEmployees;
		this.totalJobPost=totalJobPost;
		this.totalApplications=totalApplications;
	}
	public int getTotalUsers() {
		return totalUsers;
	}
	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}
	public int getTotalRecruiters() {
		return totalRecruiters;
	}
	public void setTotalRecruiters(int totalRecruiters) {
		this.totalRecruiters = totalRecruiters;
	}
	public int getTotalEmployees() {
		return totalEmployees;
	}
	public void setTotalEmployees(int totalEmployee) {
		this.totalEmployees = totalEmployee;
	}
	public int getTotalJobPost() {
		return totalJobPost;
	}
	public void setTotalJobPost(int totalJobPost) {
		this.totalJobPost = totalJobPost;
	}
	public int getTotalApplications() {
		return totalApplications;
	}
	public void setTotalApplications(int totalApplications) {
		this.totalApplications = totalApplications;
	}
	
}
