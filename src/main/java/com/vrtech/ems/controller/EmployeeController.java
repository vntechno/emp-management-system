package com.vrtech.ems.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vrtech.ems.entities.Employee;
import com.vrtech.ems.repositories.EmployeeRepository;
import com.vrtech.ems.services.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/welcome")
	public String home() {
		return "Welcome to vrtech EMS !";
	}

	@Operation(summary = "Get All empployee details ")
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@Operation(summary = "Get employee details ")
	@GetMapping("/employees/{empNo}")
	public Employee getEmployee(@PathVariable("empNo") int empNo) {
		return employeeService.getEmployee(empNo);
	}

	@Operation(summary = "Create employee resource")
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.registerEmployee(employee);
	}

	@Operation(summary = "Update employee details ")
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@Operation(summary = "Delete employee resource ")
	@DeleteMapping("/employees/{empNo}")
	public String deleteEmployee(@PathVariable("empNo") int empNo) {
		employeeService.deleteEmployee(empNo);
		return "Employee(" + empNo + ") deleted successfully";
	}
}
