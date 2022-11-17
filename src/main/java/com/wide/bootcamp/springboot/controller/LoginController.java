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
import com.wide.bootcamp.springboot.entity.Login;
import com.wide.bootcamp.springboot.service.LoginService;

import Dto.LoginDto;
import Dto.ResponseData;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<Login> viewLoginList() {
		return loginService.showAllLogin();
	}

	@GetMapping("/{id}")
	public Login findOne(@PathVariable("id") Integer id) {
		return loginService.findOne(id);
	}

	@PostMapping
	public ResponseEntity<ResponseData<Login>> create(@Valid @RequestBody LoginDto loginDto, Errors errors) {

		ResponseData<Login> responseData = new ResponseData<>();

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Login login = modelMapper.map(loginDto, Login.class);
		
		responseData.setStatus(true);
		responseData.setPayload(loginService.save(login));
		return ResponseEntity.ok(responseData);
	}

	@PutMapping
	public ResponseEntity<ResponseData<Login>> update(@Valid @RequestBody LoginDto loginDto, Errors errors) {

		ResponseData<Login> responseData = new ResponseData<>();

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Login login = modelMapper.map(loginDto, Login.class);
		responseData.setStatus(true);
		responseData.setPayload(loginService.save(login));
		return ResponseEntity.ok(responseData);
	}

	@DeleteMapping("/{id}")
	public void removeOne(@PathVariable("id") Integer id) {
		loginService.removeOne(id);
	}
}
