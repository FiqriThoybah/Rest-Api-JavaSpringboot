package com.wide.bootcamp.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wide.bootcamp.springboot.entity.Employee;

import java.util.List;

import javax.websocket.server.PathParam;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	List<Employee> findAll();
	
	@Query("SELECT emp FROM Employee emp WHERE emp.name = :name")
	public Employee findByEmployeeName (@PathParam ("name")String name);
	
	@Query("SELECT emp FROM Employee emp WHERE emp.name Like :name ")
	public List<Employee> findByEmployeeNameLike (@PathParam ("name")String name);
}
