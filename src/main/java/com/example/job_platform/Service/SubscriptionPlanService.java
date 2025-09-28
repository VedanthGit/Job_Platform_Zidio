package com.example.job_platform.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_platform.DTO.SubscriptionPlanDTO;
import com.example.job_platform.Entity.SubscriptionPlan;
import com.example.job_platform.Repository.SubscriptionPlanRepository;

@Service
public class SubscriptionPlanService {

	@Autowired
    private SubscriptionPlanRepository planRepository;

    public SubscriptionPlanDTO createPlan(SubscriptionPlanDTO dto) {
        SubscriptionPlan plan = new SubscriptionPlan();
        plan.setName(dto.getName());
        plan.setMaxJob(dto.getMaxJob());
        plan.setMaxProfile(dto.getMaxProfile());
        plan.setValidityDays(dto.getValidityDays());
        plan.setPrices(dto.getPrices());
        SubscriptionPlan saved = planRepository.save(plan);
        return convertToDTO(saved);
    }

    public List<SubscriptionPlanDTO> getAllPlans() {
        return planRepository.findAll()
                .stream().map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public SubscriptionPlanDTO getPlanById(Long id) {
        return planRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
    }
    
    public SubscriptionPlanDTO updatePlan(Long id, SubscriptionPlanDTO dto) {
        SubscriptionPlan plan = planRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
        plan.setName(dto.getName());
        plan.setMaxJob(dto.getMaxJob());
        plan.setMaxProfile(dto.getMaxProfile());
        plan.setValidityDays(dto.getValidityDays());
        plan.setPrices(dto.getPrices());
        SubscriptionPlan updated = planRepository.save(plan);
        return convertToDTO(updated);
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }
    
    private SubscriptionPlanDTO convertToDTO(SubscriptionPlan plan) {
        SubscriptionPlanDTO dto = new SubscriptionPlanDTO();
        dto.setId(plan.getId());
        dto.setName(plan.getName());
        dto.setMaxJob(plan.getMaxJob());
        dto.setMaxProfile(plan.getMaxProfile());
        dto.setValidityDays(plan.getValidityDays());
        dto.setPrices(plan.getPrices());
        return dto;
    }
}
