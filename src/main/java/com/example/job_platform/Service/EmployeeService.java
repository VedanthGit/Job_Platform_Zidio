package com.example.job_platform.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.job_platform.DTO.EmployeeDTO;
import com.example.job_platform.Entity.Employee;
import com.example.job_platform.Entity.User;
import com.example.job_platform.Enum.Role;
import com.example.job_platform.Repository.EmployeeRepository;
import com.example.job_platform.Repository.UserRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Get all employees
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Get employee by ID
    public EmployeeDTO findByEmployeeId(Long id) {
        return employeeRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    // Get employee by Email
    public EmployeeDTO findByEmployeeEmail(String email) {
        return employeeRepository.findByEmail(email)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Employee not found with email: " + email));
    }

    // Update employee
    public EmployeeDTO updateProfile(Long id, EmployeeDTO dto) {
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setPhone(dto.getPhone());
        emp.setQualification(dto.getQualification());
        emp.setResumeURL(dto.getResumeURL());
        emp.setPassword(passwordEncoder.encode(dto.getPassword()));
        

        employeeRepository.save(emp);
        return toDTO(emp);
    }

    // Create employee
    public EmployeeDTO createProfile(EmployeeDTO dto) {
        User newUser = new User();
        newUser.setName(dto.getName());
        newUser.setEmail(dto.getEmail());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser.setRole(Role.EMPLOYEE);

        User savedUser = userRepository.save(newUser);

        Employee employee = new Employee();
        employee.setUser(savedUser);
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setQualification(dto.getQualification());
        employee.setResumeURL(dto.getResumeURL());
        employee.setPassword(passwordEncoder.encode(dto.getPassword()));

        employeeRepository.save(employee);
        return toDTO(employee);
    }

    // Convert entity -> DTO
    private EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setPhone(employee.getPhone());
        dto.setQualification(employee.getQualification());
        dto.setResumeURL(employee.getResumeURL());
        dto.setUser(employee.getUser());
        return dto;
    }
}
