package com.wide.bootcamp.springboot.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.wide.bootcamp.springboot.entity.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {

	List<Login> findAll();

}
