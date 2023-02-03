package com.vrtech.ems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrtech.ems.entities.Employee;
import com.vrtech.ems.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee registerEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		if (employee.getEmpNo() != 0) {
			return employeeRepository.save(employee);
		} else {
			return null;
		}
	}

	public Employee getEmployee(int empNo) {
		return employeeRepository.getById(empNo);
	}

	public void deleteEmployee(int empNo) {
		employeeRepository.deleteById(empNo);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
