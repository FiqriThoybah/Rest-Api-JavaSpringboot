package Dto;

import javax.validation.constraints.NotEmpty;

public class DepartmentDto {
	
	@NotEmpty(message = "department name is required")
	private String department_name;
	
	@NotEmpty(message = "department location is required")
	private String department_location;

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
