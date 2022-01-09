package com.demo.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employee.exception.EmployeeNotFoundException;
import com.demo.employee.model.Employee;
import com.demo.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repo;

	public Employee addEmp(Employee employee) {
		return repo.save(employee);
	}

	public String delEmp(Long id) {

		Employee emp = getEmp(id);
		if (emp != null) {
			repo.deleteById(id);
		}
		return "Deleted Successfully";

	}

	public Employee getEmp(Long id) {
		Employee emp = repo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
		return emp;
	}

	public List<Employee> getAllEmp() {
		return repo.findAll();
	}

	public Employee updateEmp(Long id, Employee employee) {
		Employee emp = repo.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with id " + id + " not found"));
		emp.setName(employee.getName());
		emp.setDoj(employee.getDoj());
		emp.setDesignation(employee.getDesignation());
		return repo.save(emp);
	}

}
