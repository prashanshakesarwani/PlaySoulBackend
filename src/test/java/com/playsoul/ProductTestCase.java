package com.playsoul;

import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import com.playsoul.model.Product;
import com.playsoul.service.ProductService;

public class ProductTestCase 
{

	ProductService productService;
	AnnotationConfigApplicationContext context;
	Product product;
	@Before
	public void setUp()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.playsoul");
		context.refresh();
		product = (Product)context.getBean("product");
		productService=(ProductService)context.getBean("productService");
	}
	
	@Test
	public void addProduct()
	{
		boolean result;
		product.setPrice(2000);
		product.setProductName("Guitar");
		product.setQuantity(20);
		product.setCategory("Electric guitars");
		product.setDescription("An electric guitar is a guitar that uses one or more pickups to convert the vibration of its strings into electrical signals.");
		//product.setImage("23");
		result=productService.addProduct(product);
		if(result)
		{
			System.out.println("Product Added");
		}
		else
		{
			System.out.println("Error in adding Product");
		}
		
		product.setPrice(4000);
		product.setProductName("Piano");
		product.setQuantity(10);
		product.setCategory("Keyboard");
		product.setDescription("An acoustic piano usually has a protective wooden case surrounding the soundboard and metal strings, which are strung under great tension on a heavy metal frame.");
		//hgproduct.setImage("24");
		result=productService.addProduct(product);
		if(result)
		{
			System.out.println("Product Added");
		}
		else
		{
			System.out.println("Error in adding Product");
		}
		
	}
	//@Ignore
	@Test
	public void getAllProducts()
	{
		List<Product> allProducts=productService.getAllProducts();
		assertNotNull("Fetched", allProducts);
		for(Product product:allProducts)
		{
			System.out.println("Product Name:  "+product.getProductName()+"   "+"Price:  "+product.getPrice());
		}
	}
	@Ignore
	@Test
	public void getProductById()
	{
		product=productService.getProductById(67);
		System.out.println("Product Name:  "+product.getProductName()+"   "+"Price:  "+product.getPrice());
	}
	
	//@Test
	public void getProductByName()
	{
		List<Product> allProductByName=productService.getProductByName("Laptop");
		assertNotNull("Feteched", allProductByName);
		for(Product product:allProductByName)
		{
		System.out.println("Product Name:  "+product.getProductName()+"   "+"Price:  "+product.getPrice());
		}
	}
	
	@After
	public void tearDown()
	{
		context.close();
	}
}
