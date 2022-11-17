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
import com.wide.bootcamp.springboot.entity.Role;
import com.wide.bootcamp.springboot.service.RoleService;
import Dto.ResponseData;
import Dto.RoleDto;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<Role> viewRoleList() {
		return roleService.showAllRole();
	}

	@GetMapping("/{id}")
	public Role findOne(@PathVariable("id") int id) {
		return roleService.findOne(id);
	}
	
	@PostMapping
	public ResponseEntity<ResponseData<Role>> create (@Valid @RequestBody RoleDto roleDto, Errors errors){
		ResponseData<Role> responseData = new ResponseData<>();
		
		if (errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Role role = modelMapper.map(roleDto, Role.class);
		
		Department department = new Department();
		department.setDept_id(roleDto.getEmpDepartment());
		role.setDepartment(department);
		
		responseData.setStatus(true);
		responseData.setPayload(roleService.save(role));
		return ResponseEntity.ok(responseData);
	}
	
	@PutMapping
	public ResponseEntity<ResponseData<Role>> update (@Valid @RequestBody RoleDto roleDto, Errors errors){
		ResponseData<Role> responseData = new ResponseData<>();
		
		if (errors.hasErrors()) {
			for(ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Role role = modelMapper.map(roleDto, Role.class);
		responseData.setStatus(true);
		responseData.setPayload(roleService.save(role));
		return ResponseEntity.ok(responseData);
	}
	
	@DeleteMapping("/{id}")
	public void removeOne(@PathVariable  ("id") Integer id) {
		roleService.removeOne(id);
	}
	
	
}
