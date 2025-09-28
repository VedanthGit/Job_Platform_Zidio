package com.example.job_platform.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.job_platform.Service.EmployeeService;
import com.example.job_platform.DTO.EmployeeDTO;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/allEmployees")
	public ResponseEntity<List<EmployeeDTO>> findAllEmployees(){
		return ResponseEntity.ok(employeeService.findAllEmployees());
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<EmployeeDTO> getEmployeeByEmail(@PathVariable String email){
		return ResponseEntity.ok(employeeService.findByEmployeeEmail(email));
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
	    return ResponseEntity.ok(employeeService.findByEmployeeId(id));
	}

	
	@PostMapping("/create")
	public ResponseEntity<EmployeeDTO>getCreateProfile(@RequestBody EmployeeDTO dto){
		return ResponseEntity.ok(employeeService.createProfile(dto));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDTO>getUpdateProfile(@PathVariable Long id, @RequestBody EmployeeDTO dto){
		EmployeeDTO updated = employeeService.updateProfile(id, dto);
		return ResponseEntity.ok(updated);
	}
	
}
