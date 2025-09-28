package com.example.job_platform.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_platform.Enum.Status;
import com.example.job_platform.Repository.ApplicationRepository;
import com.example.job_platform.Repository.JobPostRepository;
import com.example.job_platform.DTO.ApplicationDTO;
import com.example.job_platform.DTO.ApplicationStatusUpdateDTO;
import com.example.job_platform.Entity.Application;
import com.example.job_platform.Entity.JobPost;

@Service

public class ApplicationService {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private JobPostRepository jobPostRepository;
	
	public ApplicationDTO applyJob(ApplicationDTO dto) {
	    JobPost jobPost = jobPostRepository.findById(dto.getJobId())
	        .orElseThrow(() -> new RuntimeException("Job not found with id: " + dto.getJobId()));

	    Application app = new Application();
	    app.setJobId(dto.getJobId());
	    app.setEmployeeEmail(dto.getEmployeeEmail());
	    app.setStatus(Status.APPLIED); // always set a default
	    app.setResumeURL(dto.getResumeURL());

	    // make sure recruiter email is not null
	    if (jobPost.getRecruiterEmail() == null || jobPost.getRecruiterEmail().isEmpty()) {
	        throw new RuntimeException("Recruiter email missing for jobId: " + dto.getJobId());
	    }
	    app.setRecruiterEmail(jobPost.getRecruiterEmail());

	    applicationRepository.save(app);
	    return mapToDTO(app);
	}

	public List<ApplicationDTO>getAllApplications(){
		return applicationRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<ApplicationDTO>getByEmployeeEmail(String employeeEmail){
		return applicationRepository.findByEmployeeEmail(employeeEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public List<ApplicationDTO>getByRecruiterEmail(String recruiterEmail){
		return applicationRepository.findByRecruiterEmail(recruiterEmail).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<ApplicationDTO>getByJobId(Long jobId){
		return applicationRepository.findByJobId(jobId).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public ApplicationDTO updateApplicationStatus(ApplicationStatusUpdateDTO dto) {
		
		Application app = applicationRepository.findById(dto.getApplicationId())
				.orElseThrow(() -> new RuntimeException("Application not found"));
		
		app.setStatus(dto.getStatus());
		
		applicationRepository.save(app);
		
		return mapToDTO(app);
	}
	
	private ApplicationDTO mapToDTO(Application app) {
		ApplicationDTO dto= new ApplicationDTO();
		
		dto.setId(app.getId());
		dto.setJobId(app.getJobId());
		dto.setEmployeeEmail(app.getEmployeeEmail());
		dto.setRecruiterEmail(app.getRecruiterEmail());
		dto.setStatus(app.getStatus());
		dto.setResumeURL(app.getResumeURL());
		
		return dto;
		
	}
	
	public void deleteApplication(Long id) {
	    if (!applicationRepository.existsById(id)) {
	        throw new RuntimeException("Application not found with id: " + id);
	    }
	    applicationRepository.deleteById(id);
	}
	
	public void deleteAllApplications() {
	    if (applicationRepository.count() == 0) {
	        throw new RuntimeException("No applications found");
	    }
	    applicationRepository.deleteAll();
	}


}