package com.example.job_platform.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_platform.DTO.AuditLogDTO;
import com.example.job_platform.Entity.AuditLog;
import com.example.job_platform.Repository.AuditLogRepository;

@Service
public class AuditLogService {

	@Autowired
	private AuditLogRepository auditLogRepository;
	
	public String logAction(AuditLogDTO dto) {
		AuditLog log= new AuditLog();
		
		log.setId(dto.id);
		log.setActor(dto.actor);
		log.setAction(dto.action);
		log.setTarget(dto.target);
		log.setTimeStamp(dto.timeStamp);
		log.setModule(dto.module);
		
		auditLogRepository.save(log);
		return "Audit Log Saved";
	}
	
	public List<AuditLogDTO>getLogByModule(String module){
		return auditLogRepository.findByModule(module).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<AuditLogDTO>getLogByActor(String actor){
		return auditLogRepository.findByActor(actor).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	private AuditLogDTO mapToDTO(AuditLog log) {
		AuditLogDTO dto = new AuditLogDTO();
		
		dto.setId(log.getId());
		dto.setActor(log.getActor());
		dto.setAction(log.getAction());
		dto.setModule(log.getModule());
		dto.setTarget(log.getTarget());
		dto.setTimeStamp(log.getTimeStamp());
		
		return dto;
	}
}
