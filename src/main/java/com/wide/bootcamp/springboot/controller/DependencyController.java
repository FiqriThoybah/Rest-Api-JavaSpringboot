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
import com.wide.bootcamp.springboot.entity.Dependency;
import com.wide.bootcamp.springboot.entity.Employee;
import com.wide.bootcamp.springboot.service.DependencyService;

import Dto.DependencyDto;
import Dto.ResponseData;

@RestController
@RequestMapping("/dependency")
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
public class DependencyController {

	@Autowired
	DependencyService dependencyService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<Dependency> viewDependencyList() {
		return dependencyService.showAllDependency();
	}

	@GetMapping("/{id}")
	public Dependency findOne(@PathVariable("id") Integer id) {
		return dependencyService.findOne(id);
	}

	@PostMapping
	public ResponseEntity<ResponseData<Dependency>> create(@Valid @RequestBody DependencyDto dependencyDto, Errors errors) {
		
		ResponseData<Dependency> responseData = new ResponseData<>();
		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Dependency dependency = modelMapper.map(dependencyDto, Dependency.class);
		
		Employee employee = new Employee();
		employee.setEmpId(dependencyDto.getEmpUserId());
		dependency.setEmployee(employee);
		
		responseData.setStatus(true);
		responseData.setPayload(dependencyService.save(dependency));
		return ResponseEntity.ok(responseData);
	}
	
	@PutMapping
	public ResponseEntity<ResponseData<Dependency>> update (@Valid @RequestBody DependencyDto dependencyDto, Errors errors){
		ResponseData<Dependency> responseData = new ResponseData<>();
		
		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Dependency dependency = modelMapper.map(dependencyDto, Dependency.class);
		
		responseData.setStatus(true);
		responseData.setPayload(dependencyService.save(dependency));
		return ResponseEntity.ok(responseData);
	}

	@DeleteMapping("/{id}")
	public void removeOne(@PathVariable("id") Integer id) {
		dependencyService.removeOne(id);
	}
}
