package com.demo.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee.model.Employee;
import com.demo.employee.service.EmployeeService;

@RestController
@RequestMapping("api/vi/employees")
public class Controller {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public Employee addEmployee(@RequestBody Employee data) {
		return employeeService.addEmp(data);
	}

	@DeleteMapping(path = "/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		return employeeService.delEmp(id);
	}
	
	@GetMapping(path = "/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return employeeService.getEmp(id);
	}
	
	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmp();
	}
	
	@PutMapping(path = "/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		return employeeService.updateEmp(id,employee);
	}
	
}
