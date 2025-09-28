package com.example.job_platform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_platform.Service.RecruiterService;
import com.example.job_platform.DTO.RecruiterDTO;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {
	
	@Autowired
	private RecruiterService recruiterService;
	
	@GetMapping("/allRecruiters")
	public ResponseEntity<List<RecruiterDTO>>getAllRecruiters(){
		return ResponseEntity.ok(recruiterService.getAllRecruiters());
	}
	
	@GetMapping("/recruiterEmail/{recruiterEmail}")
	public ResponseEntity<List<RecruiterDTO>>getRecruiterByEmail(@PathVariable String recruiterEmail){
		return ResponseEntity.ok(recruiterService.getRecruiterByEmail(recruiterEmail));
	}
	
	@GetMapping("/recruiterId/{recruiterId}")
	public ResponseEntity<List<RecruiterDTO>>getRecruiterById(@PathVariable Long recruiterId){
		return ResponseEntity.ok(recruiterService.getRecruiterById(recruiterId));
	}
	
	@PostMapping("/save")
	public ResponseEntity<RecruiterDTO>saveRecruiter(@RequestBody RecruiterDTO dto){
		return ResponseEntity.ok(recruiterService.createRecruiter(dto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<RecruiterDTO> updateRecruiter(@RequestBody RecruiterDTO dto) {
	    RecruiterDTO updated = recruiterService.updateRecruiterByUserId(dto.getUser().getId(), dto);
	    return ResponseEntity.ok(updated);
	}
	
}
