package com.example.job_platform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_platform.DTO.JobPostDTO;
import com.example.job_platform.Entity.JobPost;
import com.example.job_platform.Enum.JobType;
import com.example.job_platform.Service.JobPostService;

@RestController
@RequestMapping("/api/jobposts")
public class JobPostController {

	@Autowired
	private JobPostService jobPostService;
	
	@PostMapping
	public ResponseEntity<JobPost>createJobs(@RequestBody JobPostDTO dto){
		return ResponseEntity.ok(jobPostService.createJob(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<JobPost>>getAllJobs(){
		return ResponseEntity.ok(jobPostService.getAllJobs());
	}
	
	@GetMapping("/recruiters/{recruiterEmail}")
	public ResponseEntity<List<JobPost>>getByRecruiter(@PathVariable String recruiterEmail){
		return ResponseEntity.ok(jobPostService.getByRecruiter(recruiterEmail));
	}
	
	@GetMapping("/search/company/{companyName}")
	public ResponseEntity<List<JobPost>>searchJobByCompanyName(@PathVariable String companyName){
		return ResponseEntity.ok(jobPostService.searchJobByCompanyName(companyName));
	}
	
	@GetMapping("/search/title/{jobTitle}")
	public ResponseEntity<List<JobPost>>searchJobByjobTitle(@PathVariable String jobTitle){
		return ResponseEntity.ok(jobPostService.searchJobByjobTitle(jobTitle));
	}
	
	@GetMapping("/search/location/{jobLocation}")
	public ResponseEntity<List<JobPost>>searchJobByjobLocation(@PathVariable String jobLocation){
		return ResponseEntity.ok(jobPostService.searchJobByjobLocation(jobLocation));
	}
	
	@GetMapping("/search/type/{jobType}")
	public ResponseEntity<List<JobPost>>searchJobByjobType(@PathVariable JobType jobType){
		return ResponseEntity.ok(jobPostService.searchJobByjobType(jobType));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id) {
	    jobPostService.deleteJob(id);
	    return ResponseEntity.ok("JobPost with id " + id + " deleted successfully.");
	}

}
