package com.example.job_platform.DTO;

import java.time.LocalDateTime;

public class AuditLogDTO {

	public Long id;
	public String actor;
	public String action;
	public String target;
	
	public LocalDateTime timeStamp;
	
	public String module;
	
	public AuditLogDTO() {}
	public AuditLogDTO(Long id, String actor, String action, String target, LocalDateTime timeStamp, String module) {
		this.id=id;
		this.actor=actor;
		this.action=action;
		this.target=target;
		this.timeStamp=timeStamp;
		this.module=module;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
}
