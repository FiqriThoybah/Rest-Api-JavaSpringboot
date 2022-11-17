package com.wide.bootcamp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.wide.bootcamp.springboot.entity.Employee;
import com.wide.bootcamp.springboot.repository.EmployeeRepository;

@org.springframework.stereotype.Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;

	public List<Employee> showAllEmployee() {
		return employeeRepo.findAll();
	}

	public Employee findOne(Integer id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		
		if (!employee.isPresent()) {
			return null;
		}
		return employee.get();
	}

	public Employee save(Employee employee) {
		return employeeRepo.save(employee);
	}

	public void removeOne(Integer id) {
		employeeRepo.deleteById(id);
	}
	
	public Employee findByEmployeeName(String name) {
		return employeeRepo.findByEmployeeName(name);
	}
	
	public List<Employee> findByEmployeeNameLike(String name) {
		return employeeRepo.findByEmployeeNameLike("%"+name+"%");
	}
}
