package com.wide.bootcamp.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department_tbl")
public class Department {

	@Id
	private int dept_id;
	private String department_name;
	private String department_location;
	
	public Department() {
		
	}
	
//	public Department(int dept_id, String department_name, String department_location) {
//		super();
//		this.dept_id = dept_id;
//		this.department_name = department_name;
//		this.department_location = department_location;
//	}
	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getDepartment_location() {
		return department_location;
	}

	public void setDepartment_location(String department_location) {
		this.department_location = department_location;
	}

	
	
	

	
}
