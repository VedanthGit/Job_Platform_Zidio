package com.example.job_platform.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_platform.DTO.AuditLogDTO;
import com.example.job_platform.Service.AuditLogService;

@RestController
@RequestMapping("/api/auditLogs")
public class AuditLogController {

	@Autowired
	private AuditLogService auditLogService;
	
	@PostMapping
	public ResponseEntity<String>logAction(@RequestBody AuditLogDTO dto){
		dto.setTimeStamp(LocalDateTime.now());
		auditLogService.logAction(dto);
		return ResponseEntity.ok("Log is Saved");
	}
	
	@GetMapping("/log/module/{module}")
	public ResponseEntity<List<AuditLogDTO>>getLogByModule(@PathVariable String module){
		return ResponseEntity.ok(auditLogService.getLogByModule(module));
	}
	
	@GetMapping("/log/actor/{actor}")
	public ResponseEntity<List<AuditLogDTO>>getLogByActor(@PathVariable String actor){
		return ResponseEntity.ok(auditLogService.getLogByActor(actor));
	}
}
