package com.wide.bootcamp.springboot.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.wide.bootcamp.springboot.entity.Dependency;

public interface DependencyRepository extends CrudRepository<Dependency, Integer> {
	List<Dependency> findAll ();
}
