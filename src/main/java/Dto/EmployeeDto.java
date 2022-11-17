package Dto;

import javax.validation.constraints.NotEmpty;

public class EmployeeDto {

	@NotEmpty(message = "name is required")
	private String name;

	private int age;

	@NotEmpty(message = "phone is required")
	private String gender;

	@NotEmpty(message = "phone is required")
	private String phone;

	private int empAddress;

	private int empLogin;

	private int empRole;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(int empAddress) {
		this.empAddress = empAddress;
	}

	public int getEmpLogin() {
		return empLogin;
	}

	public void setEmpLogin(int empLogin) {
		this.empLogin = empLogin;
	}

	public int getEmpRole() {
		return empRole;
	}

	public void setEmpRole(int empRole) {
		this.empRole = empRole;
	}

	

}
