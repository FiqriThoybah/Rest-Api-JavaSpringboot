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
import com.wide.bootcamp.springboot.entity.Department;
import com.wide.bootcamp.springboot.service.DepartmentService;
import Dto.DepartmentDto;
import Dto.ResponseData;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public List<Department> viewRoleList() {
		return departmentService.showAllDepartment();
	}

	@GetMapping("/{id}")
	public Department findOne(@PathVariable("id") Integer id) {
		return departmentService.findOne(id);
	}
	
	@PostMapping
	public ResponseEntity<ResponseData<Department>> create(@Valid @RequestBody DepartmentDto departmentDto, Errors errors) {

		ResponseData<Department> responseData = new ResponseData<>();

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Department department = modelMapper.map(departmentDto, Department.class);
		
		responseData.setStatus(true);
		responseData.setPayload(departmentService.save(department));
		return ResponseEntity.ok(responseData);
	}
	
	@PutMapping
	public ResponseEntity<ResponseData<Department>> update (@Valid @RequestBody DepartmentDto departmentDto, Errors errors) {

		ResponseData<Department> responseData = new ResponseData<>();

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Department department = modelMapper.map(departmentDto, Department.class);
		
		responseData.setStatus(true);
		responseData.setPayload(departmentService.save(department));
		return ResponseEntity.ok(responseData);
	}
	
	@DeleteMapping("/{id}")
	public void removeOne (@PathVariable ("id")Integer id) {
		departmentService.removeOne(id);
	}
	
	
}
