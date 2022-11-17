package com.wide.bootcamp.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wide.bootcamp.springboot.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
	
	List<Role>findAll();

}
