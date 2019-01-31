package com.playsoul.service;

import java.util.List;

import com.playsoul.model.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();

	void addCustomer(Customer customer);

	Customer getCustomerByUsername(String username);

	Customer getCustomerById(int customerId);

	void updateCustomer(Customer customer);

}
