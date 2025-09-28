package com.example.job_platform.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_platform.DTO.AdminDTO;
import com.example.job_platform.DTO.SystemStatusDTO;
import com.example.job_platform.DTO.UserStatusUpdateDTO;
import com.example.job_platform.Entity.Admin;
import com.example.job_platform.Enum.Role;
import com.example.job_platform.Repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public List<AdminDTO>getAllUsers(){
		return adminRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
	}
	public List<AdminDTO>getUserByRole(Role role){
		return adminRepository.findByRole(role).stream().map(this::toDTO).collect(Collectors.toList());
	}
	public AdminDTO updateUserStatus(UserStatusUpdateDTO dto) {
	    Optional<Admin> optional = adminRepository.findById(dto.getUserId());
	    if (!optional.isPresent()) {
	        throw new RuntimeException("User not found");
	    }

	    Admin user = optional.get();

	    // update selectively (only if provided)
	    if (dto.getEmail() != null) user.setEmail(dto.getEmail());
	    if (dto.getRole() != null) user.setRole(dto.getRole());
	    if (dto.getName() != null) user.setName(dto.getName());
	    if (dto.getPassword() != null) user.setPassword(dto.getPassword()); // hash if needed

	    user.setActive(dto.isActive());

	    adminRepository.save(user);

	    return toDTO(user);
	}

	public SystemStatusDTO getSystemStatus() {
		int totalUsers=(int)adminRepository.count();
		int totalEmployees=(int)adminRepository.count();
		int totalRecruiters=(int)adminRepository.count();
		int totalJobPosts=(int)adminRepository.count();
		int totalApplications=(int)adminRepository.count();
		
		SystemStatusDTO status = new SystemStatusDTO();
		status.setTotalUsers(totalUsers);
		status.setTotalEmployees(totalEmployees);
		status.setTotalRecruiters(totalRecruiters);
		status.setTotalJobPost(totalJobPosts);
		status.setTotalApplications(totalApplications);
		
		return status;
		
	}
	private AdminDTO toDTO(Admin admin) {
	    AdminDTO dto = new AdminDTO();
	    dto.setId(admin.getId());
	    dto.setName(admin.getName());
	    dto.setEmail(admin.getEmail());
	    dto.setRole(admin.getRole());
	    dto.setActive(admin.isActive());
	    dto.setUser(admin.getUser());
	    return dto;
	}

}
