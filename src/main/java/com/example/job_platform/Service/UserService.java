package com.example.job_platform.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_platform.Entity.Admin;
import com.example.job_platform.Entity.Employee;
import com.example.job_platform.Entity.Recruiter;
import com.example.job_platform.Entity.User;
import com.example.job_platform.Enum.Role;
import com.example.job_platform.Repository.AdminRepository;
import com.example.job_platform.Repository.EmployeeRepository;
import com.example.job_platform.Repository.RecruiterRepository;
import com.example.job_platform.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AdminRepository adminRepository;

    
    @Autowired
    private RecruiterRepository recruiterRepository;

    public User registerUser(User user) {
        // Save user
        User savedUser = userRepository.save(user);

        // Auto-create recruiter row if role is RECRUITER
        if (savedUser.getRole().equals(Role.RECRUITER)) {
            Recruiter recruiter = new Recruiter();
            recruiter.setUser(savedUser);
            recruiterRepository.save(recruiter);
        } else if (savedUser.getRole().equals(Role.EMPLOYEE)) {
            Employee employee = new Employee();
            employee.setUser(savedUser);
            employeeRepository.save(employee);
        } else if (savedUser.getRole().equals(Role.ADMIN)) {
            Admin admin = new Admin();
            admin.setUser(savedUser);
            adminRepository.save(admin);
        }
        return savedUser;
    }
}
