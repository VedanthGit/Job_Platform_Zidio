package com.example.job_platform.Entity;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "auditLogs")
public class AuditLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String actor;
	private String action;
	private String target;
	
	private LocalDateTime timeStamp;
	
	private String module;
	
	public AuditLog() {}
	public AuditLog(Long id, String actor, String action, String target, LocalDateTime timeStamp, String module) {
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
