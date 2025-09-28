package com.example.job_platform.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_platform.DTO.JobPostDTO;
import com.example.job_platform.Entity.JobPost;
import com.example.job_platform.Entity.Recruiter;
import com.example.job_platform.Enum.JobType;
import com.example.job_platform.Repository.JobPostRepository;
import com.example.job_platform.Repository.RecruiterRepository;

@Service
public class JobPostService {
	
	@Autowired
	private JobPostRepository jobPostRepository;
	
	@Autowired
	private RecruiterRepository recruiterRepository;
	
	public JobPost createJob(JobPostDTO dto) {
		JobPost job = new JobPost();
		
		job.setId(dto.id);
		job.setCompanyName(dto.companyName);
		job.setJobDescription(dto.jobDescription);
		job.setJobLocation(dto.jobLocation);
		job.setJobTitle(dto.jobTitle);
		job.setJobType(dto.jobType);
		job.setPostedDate(LocalDate.now());
		job.setDeadLineDate(LocalDate.now().plusDays(22));
		job.setRecruiterId(dto.recruiterId);
		Recruiter recruiter = recruiterRepository.findById(dto.recruiterId)
		        .orElseThrow(() -> new RuntimeException("Recruiter not found"));
		    job.setRecruiterEmail(recruiter.getRecruiterEmail());
		
		return jobPostRepository.save(job);
		
	}
	public List<JobPost>getAllJobs(){
		return jobPostRepository.findAll();
	}
	
	public List<JobPost>getByRecruiter(String recruiterEmail){
		return jobPostRepository.findByRecruiterEmail(recruiterEmail);
	}
	public List<JobPost>searchJobByCompanyName(String companyName){
		return jobPostRepository.findByCompanyName(companyName);
	}
	public List<JobPost>searchJobByjobTitle(String jobTitle){
		return jobPostRepository.findByJobTitle(jobTitle);
	}
	public List<JobPost>searchJobByjobType(JobType jobType){
		return jobPostRepository.findByJobType(jobType);
	}
	public List<JobPost>searchJobByjobLocation(String jobLocation){
		return jobPostRepository.findByJobLocation(jobLocation);
	}
	public List<JobPost>searchJobByRecuiter(Long recruiterId){
		return jobPostRepository.findByRecruiterId(recruiterId);
	}
	
	public void deleteJob(Long id) {
	    if (!jobPostRepository.existsById(id)) {
	        throw new RuntimeException("JobPost not found with id: " + id);
	    }
	    jobPostRepository.deleteById(id);
	}

}
