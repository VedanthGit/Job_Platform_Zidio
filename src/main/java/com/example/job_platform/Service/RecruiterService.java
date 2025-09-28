package com.example.job_platform.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.job_platform.Repository.RecruiterRepository;
import com.example.job_platform.Repository.UserRepository;
import com.example.job_platform.DTO.RecruiterDTO;
import com.example.job_platform.Entity.Recruiter;
import com.example.job_platform.Entity.User;
import com.example.job_platform.Enum.Role;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<RecruiterDTO> getAllRecruiters() {
        return recruiterRepository.findAll().stream()
        		.map(this::toDTO)
        		.collect(Collectors.toList());
    }

    public List<RecruiterDTO> getRecruiterByEmail(String recruiterEmail) {
        return recruiterRepository.findByRecruiterEmail(recruiterEmail).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<RecruiterDTO> getRecruiterById(Long recruiterId) {
        return recruiterRepository.findById(recruiterId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // ===== UPDATED: Update by user_id =====
    public RecruiterDTO updateRecruiterByUserId(Long id, RecruiterDTO dto) {
        Optional<Recruiter> existingOpt = recruiterRepository.findByUserId(id);

        if (existingOpt.isEmpty()) {
            throw new RuntimeException("Recruiter not found for user_id: " + id);
        }

        Recruiter recruiter = existingOpt.get();
        recruiter.setRecruiterName(dto.getRecruiterName());
        recruiter.setCompanyName(dto.getCompanyName());
        recruiter.setRecruiterEmail(dto.getRecruiterEmail());
        recruiter.setRecruiterPhone(dto.getRecruiterPhone());
        recruiter.setDesignation(dto.getDesignation());
        recruiter.setPassword(passwordEncoder.encode(dto.getPassword()));

        recruiterRepository.save(recruiter);
        return toDTO(recruiter);
    }

    public RecruiterDTO createRecruiter(RecruiterDTO dto) {
        // Step 1: create a new User
        User newUser = new User();
        newUser.setName(dto.getRecruiterName());
        newUser.setEmail(dto.getRecruiterEmail());
        newUser.setPassword(passwordEncoder.encode(dto.getPassword()));
        newUser.setRole(Role.RECRUITER);

        User savedUser = userRepository.save(newUser);

        // Step 2: create a new Recruiter linked to the new User
        Recruiter recruiter = new Recruiter();
        recruiter.setUser(savedUser);
        recruiter.setRecruiterName(dto.getRecruiterName());
        recruiter.setCompanyName(dto.getCompanyName());
        recruiter.setRecruiterEmail(dto.getRecruiterEmail());
        recruiter.setRecruiterPhone(dto.getRecruiterPhone());
        recruiter.setDesignation(dto.getDesignation());
        recruiter.setPassword(passwordEncoder.encode(dto.getPassword()));

        recruiterRepository.save(recruiter);

        return toDTO(recruiter);
    }

    private RecruiterDTO toDTO(Recruiter recruiter) {
        RecruiterDTO dto = new RecruiterDTO();
        dto.setId(recruiter.getId());
        dto.setRecruiterName(recruiter.getRecruiterName());
        dto.setCompanyName(recruiter.getCompanyName());
        dto.setRecruiterEmail(recruiter.getRecruiterEmail());
        dto.setRecruiterPhone(recruiter.getRecruiterPhone());
        dto.setDesignation(recruiter.getDesignation());
        dto.setUser(recruiter.getUser());
        return dto;
    }
}
