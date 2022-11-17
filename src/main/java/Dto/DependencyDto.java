package Dto;

import javax.validation.constraints.NotEmpty;

public class DependencyDto {

	@NotEmpty(message = "name is required")
	private String name;
	
	@NotEmpty(message = "status is required")
	private String status;
	
	@NotEmpty(message = "gender is required")
	private String gender;
	
	@NotEmpty(message = "age group is required")
	private String age_group;
	
	private int empUserId;
	

	public int getEmpUserId() {
		return empUserId;
	}

	public void setEmpUserId(int empUserId) {
		this.empUserId = empUserId;
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
	
	
}
