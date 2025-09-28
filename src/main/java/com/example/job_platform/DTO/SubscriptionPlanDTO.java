package com.example.job_platform.DTO;

public class SubscriptionPlanDTO {

	public Long id;
	public String name;
	public int maxJob;
	public int maxProfile;
	public int validityDays;
	public double prices;
	
	public SubscriptionPlanDTO() {}
	public SubscriptionPlanDTO(Long id, String name, int maxJob, int maxProfile, int validityDays, double prices) {
		this.id=id;
		this.name=name;
		this.maxJob=maxJob;
		this.maxProfile=maxProfile;
		this.validityDays=validityDays;
		this.prices=prices;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMaxJob() {
		return maxJob;
	}
	public void setMaxJob(int maxJob) {
		this.maxJob = maxJob;
	}
	public int getMaxProfile() {
		return maxProfile;
	}
	public void setMaxProfile(int maxProfile) {
		this.maxProfile = maxProfile;
	}
	public int getValidityDays() {
		return validityDays;
	}
	public void setValidityDays(int validityDays) {
		this.validityDays = validityDays;
	}
	public double getPrices() {
		return prices;
	}
	public void setPrices(double prices) {
		this.prices = prices;
	}
	
}
