package com.example.job_platform.Service;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.job_platform.DTO.PaidSubscriptionDTO;
import com.example.job_platform.Entity.PaidSubscription;
import com.example.job_platform.Repository.PaidSubscriptionRepository;
import com.example.job_platform.Security.InvoiceGenerator;

@Service
public class PaidSubscriptionService {

    @Autowired
    private PaidSubscriptionRepository paidSubscriptionRepository;

    public PaidSubscriptionDTO createSubscription(PaidSubscriptionDTO dto) {
    		PaidSubscription sub = new PaidSubscription();
    		sub.setEmployeeId(dto.getEmployeeId());
    		sub.setRecruiterId(dto.getRecruiterId());
    		sub.setPlanId(dto.getPlanId());
    		sub.setUserEmail(dto.getUserEmail());
    		sub.setPaymentStatus(dto.getPaymentStatus());
    		sub.setStartDate(LocalDate.now());
    		sub.setEndDate(LocalDate.now().plusMonths(1));
    		sub.setAmount(dto.getAmount());
    		sub.setCurrency(dto.getCurrency());
    		sub.setInvoiceUrl(dto.getInvoiceUrl());
    		paidSubscriptionRepository.save(sub);
        return mapToDTO(sub);
    }

    public List<PaidSubscriptionDTO> getSubscriptionByUserEmail(String userEmail) {
        return paidSubscriptionRepository.findByUserEmail(userEmail)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<PaidSubscriptionDTO> getSubscriptionByEmployeeId(Long employeeId) {
        return paidSubscriptionRepository.findByEmployeeId(employeeId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<PaidSubscriptionDTO> getSubscriptionByRecruiterId(Long recruiterId) {
        return paidSubscriptionRepository.findByRecruiterId(recruiterId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<PaidSubscriptionDTO> getAll() {
        return paidSubscriptionRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public ByteArrayInputStream generateInvoice(Long id) {
        PaidSubscription sub = paidSubscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
        return InvoiceGenerator.generateInvoice(sub);
    }

    private PaidSubscriptionDTO mapToDTO(PaidSubscription sub) {
        PaidSubscriptionDTO dto = new PaidSubscriptionDTO();

        dto.setId(sub.getId());
        dto.setEmployeeId(sub.getEmployeeId());
        dto.setRecruiterId(sub.getRecruiterId());
        dto.setPlanId(sub.getPlanId());
        dto.setUserEmail(sub.getUserEmail());
        dto.setAmount(sub.getAmount());
        dto.setCurrency(sub.getCurrency());
        dto.setPaymentStatus(sub.getPaymentStatus());
        dto.setStartDate(sub.getStartDate());
        dto.setEndDate(sub.getEndDate());
        dto.setInvoiceUrl(sub.getInvoiceUrl());

        return dto;
    }
}
