package com.playsoul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playsoul.dao.CustomerDAO;
import com.playsoul.model.Customer;
import com.playsoul.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	CustomerDAO customerDAO;
	
	public void addCustomer(Customer customer)
	{
        customerDAO.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId)
    {
        return customerDAO.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers()
    {
        return customerDAO.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username)
    {
        return customerDAO.getCustomerByUsername(username);
    }

	@Override
	public void updateCustomer(Customer customer) 
	{
		customerDAO.updateCustomer(customer);
		
	}
}