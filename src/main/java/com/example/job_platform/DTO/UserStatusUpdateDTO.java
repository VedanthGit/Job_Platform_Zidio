package com.example.job_platform.DTO;

import com.example.job_platform.Enum.Role;

public class UserStatusUpdateDTO {

	public Long userId;
	public boolean active;
	public String name;
	public String email;
	public String password;
	public Role role;
	
	public UserStatusUpdateDTO() {}
	public UserStatusUpdateDTO(Long userId,boolean active, String name, String email, String password, Role role) {
		this.userId=userId;
		this.active=active;
		this.name=name;
		this.email=email;
		this.password=password;
		this.role=role;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
}
