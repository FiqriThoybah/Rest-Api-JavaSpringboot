package com.wide.bootcamp.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.wide.bootcamp.springboot.entity.Login;
import com.wide.bootcamp.springboot.repository.LoginRepository;

@org.springframework.stereotype.Service
public class LoginService {

	@Autowired
	LoginRepository loginrepo;

	public List<Login> showAllLogin() {
		return loginrepo.findAll();
	}

	public Login findOne(Integer id) {
		Optional<Login> login = loginrepo.findById(id);
		
		if (!login.isPresent()) {
			return null;
		}
		return login.get();
	}

	public Login save(Login login) {
		return loginrepo.save(login);

	}

	public void removeOne(Integer id) {
		loginrepo.deleteById(id);
	}
}
