package com.playsoul.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.playsoul.dao.CustomerDAO;
import com.playsoul.model.Authorities;
import com.playsoul.model.Cart;
import com.playsoul.model.Customer;
import com.playsoul.model.User;

import java.util.List;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO 
{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer)
    {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        User newUser = new User();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(customer.getUsername());
        newAuthorities.setRole("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public Customer getCustomerById(int customerId)
    {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();
        return customerList;

    }

    public Customer getCustomerByUsername(String username)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);
        return (Customer) query.uniqueResult();
    }

	public Customer updateCustomer(Customer customer) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(customer);
			return customer;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
}
