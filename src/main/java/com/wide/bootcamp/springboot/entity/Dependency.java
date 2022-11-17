package com.wide.bootcamp.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "dependency_tbl")
public class Dependency {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dependency_id;
	private String name;
	private String status;
	private String gender;
	private String age_group;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "emp_id")
	@Cascade(CascadeType.ALL)
	private Employee employee;

	public Dependency() {

	}

	public int getDependency_id() {
		return dependency_id;
	}

	public void setDependency_id(int dependency_id) {
		this.dependency_id = dependency_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge_group() {
		return age_group;
	}

	public void setAge_group(String age_group) {
		this.age_group = age_group;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
