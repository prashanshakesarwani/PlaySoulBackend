package com.playsoul.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playsoul.dao.ProductDAO;
import com.playsoul.model.Product;
import com.playsoul.service.ProductService;

@Service(value="productService")
public class ProductServiceImpl implements ProductService
{

	@Autowired
	ProductDAO productDAO;
	
	public List<Product> getAllProducts() {
		List<Product> allProducts=productDAO.getAllProducts();
		if(allProducts!=null)
		{
			return allProducts;
		}
		else
		{
			return null;
		}
	}

	public boolean addProduct(Product product) {
		if(productDAO.addProduct(product))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Product> getProductByName(String productName) {
		List<Product> allProductByName=productDAO.getProductByName(productName);
		if(allProductByName!=null)
		{
			return allProductByName;
		}
		else
		{
			return null;
		}
	}

	@Override
	public Product getProductById(int productId) 
	{
		Product allProductById=productDAO.getProductById(productId);
		if(allProductById!=null)
		{
			return allProductById;
		}
		else
		{
			return null;
		}
	}

	@Override
	public boolean updateProduct(Product product) 
	{
		if(productDAO.updateProduct(product))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		if(productDAO.deleteProduct(product))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
