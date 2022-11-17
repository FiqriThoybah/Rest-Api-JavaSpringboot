package com.wide.bootcamp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.wide.bootcamp.springboot.entity.Dependency;
import com.wide.bootcamp.springboot.repository.DependencyRepository;

@org.springframework.stereotype.Service
public class DependencyService {

	@Autowired
	DependencyRepository dependencyRepo;

	public List<Dependency> showAllDependency() {
		return dependencyRepo.findAll();
	}

	public Dependency findOne(Integer id) {
		Optional<Dependency> dependency = dependencyRepo.findById(id);
		
		if (!dependency.isPresent()) {
			return null;
		}
		return dependency.get();
	}

	public Dependency save(Dependency dependency) {
		return dependencyRepo.save(dependency);
	}

	public void removeOne(Integer id) {
		dependencyRepo.deleteById(id);
	}
}
