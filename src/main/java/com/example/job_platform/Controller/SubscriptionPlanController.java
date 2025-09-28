package com.example.job_platform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_platform.DTO.SubscriptionPlanDTO;
import com.example.job_platform.Service.SubscriptionPlanService;

@RestController
@RequestMapping("/api/plans")
public class SubscriptionPlanController {

	@Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @PostMapping
    public ResponseEntity<SubscriptionPlanDTO> createPlan(@RequestBody SubscriptionPlanDTO dto) {
        return ResponseEntity.ok(subscriptionPlanService.createPlan(dto));
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionPlanDTO>> getAllPlans() {
        return ResponseEntity.ok(subscriptionPlanService.getAllPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionPlanDTO> getPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(subscriptionPlanService.getPlanById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionPlanDTO> updatePlan(@PathVariable Long id, @RequestBody SubscriptionPlanDTO dto) {
        return ResponseEntity.ok(subscriptionPlanService.updatePlan(id, dto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
    	subscriptionPlanService.deletePlan(id);
        return ResponseEntity.ok("Plan deleted successfully");
    }
}
