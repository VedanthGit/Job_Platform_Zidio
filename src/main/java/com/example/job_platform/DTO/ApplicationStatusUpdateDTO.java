package com.example.job_platform.DTO;

import com.example.job_platform.Enum.Status;

public class ApplicationStatusUpdateDTO {

	public Long applicationId;
	public Status status;
	
	
	public ApplicationStatusUpdateDTO() {}
	public ApplicationStatusUpdateDTO(Long applicationId,Status status) {
		this.applicationId=applicationId;
		this.status=status;
	}
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}