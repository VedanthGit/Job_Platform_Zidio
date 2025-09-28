package com.example.job_platform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_platform.Service.ApplicationService;
import com.example.job_platform.DTO.ApplicationDTO;
import com.example.job_platform.DTO.ApplicationStatusUpdateDTO;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    
    @GetMapping("/allApplications")
    public ResponseEntity<List<ApplicationDTO>> getAllApplications(){
    	return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/job/employee/{email:.+}")
    public ResponseEntity<List<ApplicationDTO>> getByEmployeeEmail(@PathVariable("email") String employeeEmail) {
        return ResponseEntity.ok(applicationService.getByEmployeeEmail(employeeEmail));
    }

    @GetMapping("/job/recruiter/{email:.+}")
    public ResponseEntity<List<ApplicationDTO>> getByRecruiterEmail(@PathVariable("email") String recruiterEmail) {
        return ResponseEntity.ok(applicationService.getByRecruiterEmail(recruiterEmail));
    }

    @GetMapping("/job/id/{jobId}")
    public ResponseEntity<List<ApplicationDTO>> getByJobId(@PathVariable Long jobId) {
        return ResponseEntity.ok(applicationService.getByJobId(jobId));
    }

    @PutMapping("/status")
    public ResponseEntity<ApplicationDTO> updateApplicationStatus(@RequestBody ApplicationStatusUpdateDTO dto) {
    	ApplicationDTO saved = applicationService.updateApplicationStatus(dto);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/apply")
    public ResponseEntity<ApplicationDTO> apply(@RequestBody ApplicationDTO dto) {
        ApplicationDTO saved = applicationService.applyJob(dto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok("Application deleted successfully with id: " + id);
    }
    
    @DeleteMapping
    public ResponseEntity<String> deleteAllApplications(){
    	applicationService.deleteAllApplications();
    	return ResponseEntity.ok("All applications deleted successfully.");
    }
}
