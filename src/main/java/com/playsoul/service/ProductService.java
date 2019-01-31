package com.playsoul.service;

import java.util.List;

import com.playsoul.model.Product;

public interface ProductService
{

	List<Product> getAllProducts();
	boolean addProduct(Product product);
	List<Product> getProductByName(String productName);
	Product getProductById(int productId);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
}
