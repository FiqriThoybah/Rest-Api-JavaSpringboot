package com.wide.bootcamp.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wide.bootcamp.springboot.entity.Department;
import com.wide.bootcamp.springboot.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepo;

	public List<Department> showAllDepartment() {
		return departmentRepo.findAll();
	}

	public Department findOne(Integer id) {
		Optional<Department> department = departmentRepo.findById(id);
		
		if (!department.isPresent()) {
			return null;
		}
		return department.get();

	}
	
	public Department save (Department department) {
		return departmentRepo.save(department);
	}
	
	public void removeOne (Integer id) {
		departmentRepo.deleteById(id);
	}
	


}
