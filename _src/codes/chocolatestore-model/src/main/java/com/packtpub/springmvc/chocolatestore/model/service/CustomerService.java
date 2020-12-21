package com.packtpub.springmvc.chocolatestore.model.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.packtpub.springmvc.chocolatestore.model.Customer;

@RooService(domainTypes = { com.packtpub.springmvc.chocolatestore.model.Customer.class })
public interface CustomerService {
	public void saveCustomer(Customer customer);
	
	public Customer findCustomer(String name);
}
