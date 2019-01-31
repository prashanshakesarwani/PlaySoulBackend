package com.playsoul.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.playsoul.dao.ProductDAO;
import com.playsoul.model.Product;

@Repository(value="productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public List<Product> getAllProducts() 
	{
		List<Product> allProducts=new ArrayList<Product>();
		try
		{
			allProducts=sessionFactory.getCurrentSession().createQuery("from Product").list();
			return allProducts;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean addProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getProductByName(String productName) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Criteria criteria=session.createCriteria(Product.class);
			criteria.add((Restrictions.eq("productName", productName)));
			List<Product> allProductByName=criteria.list();
			return allProductByName;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Product getProductById(int productId) 
	{	
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Product allProductById=session.get(Product.class,productId);
			return allProductById;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	
	}

	@Override
	public boolean updateProduct(Product product) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

}
