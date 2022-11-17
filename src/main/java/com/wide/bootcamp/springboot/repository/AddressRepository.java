package com.wide.bootcamp.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.wide.bootcamp.springboot.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{
	
	List<Address> findAll();
}

