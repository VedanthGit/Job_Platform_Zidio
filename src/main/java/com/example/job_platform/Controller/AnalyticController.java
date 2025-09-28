package com.example.job_platform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_platform.DTO.AnalyticsResponse;
import com.example.job_platform.Service.AnalyticService;



@RestController
@RequestMapping("/api/dashBoard")
public class AnalyticController {

	@Autowired
	private AnalyticService analyticService;
	
	@GetMapping("/summary")
	public ResponseEntity<AnalyticsResponse>getSummary(){
		return ResponseEntity.ok(analyticService.collectData());
	}
}
