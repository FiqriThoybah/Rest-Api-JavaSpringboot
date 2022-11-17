package com.wide.bootcamp.springboot.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wide.bootcamp.springboot.entity.Role;
import com.wide.bootcamp.springboot.repository.RoleRepository;

@Service
@Transactional
public class RoleService {

	@Autowired
	RoleRepository roleRepo;

	public List<Role> showAllRole() {
		return roleRepo.findAll();
	}

	public Role findOne(Integer id) {
		Optional<Role> role = roleRepo.findById(id);
		if (!role.isPresent()) {
			return null;
		}
		return role.get();

	}
	
	public Role save (Role role) {
		return roleRepo.save(role);
	}
	
	public void removeOne(Integer id) {
		roleRepo.deleteById(id);
	}

}
