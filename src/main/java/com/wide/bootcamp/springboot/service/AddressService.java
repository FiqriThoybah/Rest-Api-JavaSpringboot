package com.wide.bootcamp.springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.wide.bootcamp.springboot.entity.Address;
import com.wide.bootcamp.springboot.repository.AddressRepository;

@org.springframework.stereotype.Service
public class AddressService {
	@Autowired
	AddressRepository addressRepo;

	public List<Address> showAllAddress() {
		return addressRepo.findAll();
	}

	public Address save(Address address) {
		return addressRepo.save(address);

	}

	public Address findOne(Integer id) {
		Optional<Address> address = addressRepo.findById(id);
		if (!address.isPresent()) {
			return null;
		}
		return address.get();

	}

	public void removeOne(Integer id) {
		addressRepo.deleteById(id);
	}

}
