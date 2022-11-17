	package com.wide.bootcamp.springboot.controller;

import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wide.bootcamp.springboot.entity.Address;
import com.wide.bootcamp.springboot.entity.Employee;
import com.wide.bootcamp.springboot.entity.Login;
import com.wide.bootcamp.springboot.entity.Role;
import com.wide.bootcamp.springboot.service.EmployeeService;
import Dto.EmployeeDto;
import Dto.ResponseData;
import Dto.SearchData;

@RestController
@RequestMapping("/employee")
@CrossOrigin (origins = "http://localhost:3000/", maxAge = 3600)
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<Employee> viewEmployeeList() {
		return employeeService.showAllEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee findOne(@PathVariable("id") Integer id) {
		return employeeService.findOne(id);
	}
	

	@PostMapping
	public ResponseEntity<ResponseData<Employee>> create (@Valid @RequestBody EmployeeDto employeeDto, Errors errors){
		ResponseData<Employee> responseData = new ResponseData<>();
		
		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Employee employee = modelMapper.map(employeeDto, Employee.class); // transform employeeto to objeck employee 
		
		Address address = new Address();
		address.setAddressId(employeeDto.getEmpAddress());
		employee.setAddress(address);
		
		Login login = new Login();
		login.setLogin_id(employeeDto.getEmpLogin());
		employee.setLogin(login);
		
		Role role = new Role();
		role.setRoleId(employeeDto.getEmpRole());
		employee.setRole(role);
		
		responseData.setStatus(true);
		responseData.setPayload(employeeService.save(employee));
		return ResponseEntity.ok(responseData);
	}

//	@PutMapping
//	public ResponseEntity<ResponseData<Employee>> update (@Valid @RequestBody EmployeeDto employeeDto, Errors errors){
//		ResponseData<Employee> responseData = new ResponseData<>();
//		
//		if (errors.hasErrors()) {
//			for (ObjectError error : errors.getAllErrors()) {
//				responseData.getMessages().add(error.getDefaultMessage());
//			}
//			responseData.setStatus(false);
//			responseData.setPayload(null);
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
//		}
//		Employee employee = modelMapper.map(employeeDto, Employee.class); // transform employeeto to objeck employee 
//		
//		Address address = new Address();
//		address.setAddressId(employeeDto.getEmpAddress());
//		employee.setAddress(address);
//		
//		Login login = new Login();
//		login.setLogin_id(employeeDto.getEmpLogin());
//		employee.setLogin(login);
//		
//		Role role = new Role();
//		role.setRoleId(employeeDto.getEmpRole());
//		employee.setRole(role);
//		
//		responseData.setStatus(true);
//		responseData.setPayload(employeeService.save(employee));
//		return ResponseEntity.ok(responseData);
//	}
	
	
	@PutMapping
	public ResponseEntity<ResponseData<Employee>> update (@Valid @RequestBody Employee employee, Errors errors){
	ResponseData<Employee> responseData = new ResponseData<>();
		
		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		
		responseData.setStatus(true);
		responseData.setPayload(employeeService.save(employee));
		return ResponseEntity.ok(responseData);
	}
	
	
	@DeleteMapping("/{id}")
	public void removeOne (@PathVariable ("id") Integer id) {
		employeeService.removeOne(id);
	}
	
	@PostMapping("/search/name")
	public Employee getEmployeeByName(@RequestBody SearchData searchData) {
		return employeeService.findByEmployeeName(searchData.getSearchKey());
	}
	
	@PostMapping("/search/namelike")
	public List <Employee> getEmployeeByNameLike(@RequestBody SearchData searchData) {
		return employeeService.findByEmployeeNameLike(searchData.getSearchKey());
	}
	
}
