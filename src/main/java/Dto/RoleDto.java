package Dto;

import javax.validation.constraints.NotEmpty;

public class RoleDto {

	@NotEmpty(message = "role is required")
	private String roleName;
	
	private int empDepartment;
	

	public int getEmpDepartment() {
		return empDepartment;
	}

	public void setEmpDepartment(int empDepartment) {
		this.empDepartment = empDepartment;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	
	
}
