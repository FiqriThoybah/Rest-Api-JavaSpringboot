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
import com.wide.bootcamp.springboot.service.AddressService;

import Dto.AddressDto;
import Dto.ResponseData;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<Address> viewAddressList() {
		return addressService.showAllAddress();
	}

	@GetMapping("/{id}")
	public Address findOne(@PathVariable("id") Integer id) {
		return addressService.findOne(id);
	}

	@PostMapping
	public ResponseEntity<ResponseData<Address>> create(@Valid @RequestBody AddressDto addressDto, Errors errors) {

		ResponseData<Address> responseData = new ResponseData<>();

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Address address = modelMapper.map(addressDto, Address.class);
		
		responseData.setStatus(true);
		responseData.setPayload(addressService.save(address));
		return ResponseEntity.ok(responseData);
	}

	@PutMapping
	public ResponseEntity<ResponseData<Address>> update(@Valid @RequestBody AddressDto addressDto, Errors erros) {

		ResponseData<Address> responseData = new ResponseData<>();

		if (erros.hasErrors()) {
			for (ObjectError error : erros.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		}
		Address address = modelMapper.map(addressDto, Address.class);
		
		responseData.setStatus(true);
		responseData.setPayload(addressService.save(address));
		return ResponseEntity.ok(responseData);
	}
	
//	@PutMapping
//	public ResponseEntity<ResponseData<Address>> update (@Valid @RequestBody Address address, Errors errors){
//		ResponseData<Address> responseData = new ResponseData<>();
//		
//		if (errors.hasErrors()) {
//			for (ObjectError error : errors.getAllErrors()) {
//				responseData.getMessages().add(error.getDefaultMessage());
//			}
//			responseData.setStatus(false);
//			responseData.setPayload(null);
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
//		}
//		responseData.setStatus(true);
//		responseData.setPayload(addressService.save(address));
//		return ResponseEntity.ok(responseData);
//	}
	

	@DeleteMapping("/{id}")
	public void removeOne(@PathVariable("id") Integer id) {
		addressService.removeOne(id);
	}

}
