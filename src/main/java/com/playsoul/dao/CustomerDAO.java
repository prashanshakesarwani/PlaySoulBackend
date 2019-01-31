package com.playsoul.dao;

import java.util.List;

import com.playsoul.model.Customer;

public interface CustomerDAO 
{
	void addCustomer(Customer customer);
	Customer getCustomerById(int customerId);
	List<Customer> getAllCustomers();
	Customer getCustomerByUsername(String username);
	Customer updateCustomer(Customer customer);
}
