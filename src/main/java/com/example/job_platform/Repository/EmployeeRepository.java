package com.example.job_platform.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.job_platform.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	Optional<Employee>findByEmail(String email);

}