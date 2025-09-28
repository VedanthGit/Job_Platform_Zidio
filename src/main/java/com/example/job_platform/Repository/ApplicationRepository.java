package com.example.job_platform.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.job_platform.Entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long>{
	
	
	List<Application>findByEmployeeEmail(String employeeEmail);
	List<Application>findByRecruiterEmail(String recruiterEmail);
	List<Application>findByJobId(Long jobId);
	Optional<Application> findById(Long Id);
}
