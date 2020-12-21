package com.packtpub.springmvc.chocolatestore.model.service;

import com.packtpub.springmvc.chocolatestore.model.Customer;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	public long countAllCustomers() {
        return Customer.countCustomers();
    }

	public void deleteCustomer(Customer customer) {
        customer.remove();
    }

	public Customer findCustomer(Long id) {
        return Customer.findCustomer(id);
    }
	
	public Customer findCustomer(String name) {
        return Customer.findCustomersByNameEquals(name).getSingleResult();
    }

	public List<Customer> findAllCustomers() {
        return Customer.findAllCustomers();
    }

	public List<Customer> findCustomerEntries(int firstResult, int maxResults) {
        return Customer.findCustomerEntries(firstResult, maxResults);
    }

	public void saveCustomer(Customer customer) {
        customer.persist();
    }

	public Customer updateCustomer(Customer customer) {
        return customer.merge();
    }
}
