package com.wide.bootcamp.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wide.bootcamp.springboot.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Integer>{

	List<Department> findAll();
	

}
