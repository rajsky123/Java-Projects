package com.shopping.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.app.dto.Product;
import com.shopping.app.productdao.ProductDao;

public class TestProduct {
private static AnnotationConfigApplicationContext ctx;
	
	private static ProductDao productDao;
	
	
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.shopping.app");
		ctx.refresh();
		
		productDao= ctx.getBean(ProductDao.class);
	}
	
	/*@org.junit.Test
	public void getProductById() {
		
		Product product=new Product();
		
		
		assertEquals("Something went wrong", 1, productDao.get(1).getId());
		
	}

	@org.junit.Test
	public void listProducts() {
		
		assertEquals("Something went wrong", 5, productDao.list().size());
		
	}  */

	/*@org.junit.Test
	public void add() {
		
		Product product=new Product();
		product.setName("Redmi Note 5");
		product.setBrand("Redmi");
		product.setDescription("This is a Redmi note ");
		product.setUnitPrice(14999);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Something went wrong", true, productDao.add(product));
		
	}*/
	
	/*@org.junit.Test
	public void update() {
		
		product=productDao.get(3);
		
		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong", true, productDao.update(product));
		
	}*/
	
	/*@org.junit.Test
	public void delete() {
		
		product=productDao.get(3);
		
		
		assertEquals("Something went wrong", true, productDao.delete(product));
		
	}*/
	
	/*@org.junit.Test
	public void listActiveProducts() {
		
		assertEquals("Something went wrong", 7, productDao.listActiveProducts().size());
		
	}*/
	
	/*@org.junit.Test
	public void listActiveProductsByCategory() {
		
		
		assertEquals("Something went wrong", 2, productDao.listActiveProductsByCategory(1).size());
		
	}*/
	
	@org.junit.Test
	public void listActiveProductsByCategory() {
		
		
		assertEquals("Something went wrong", 2, productDao.listActiveProductsByCategory(1).size());
		
	}@org.junit.Test
	public void getLatestActiveProducts() {
		
		
		assertEquals("Something went wrong", 3, productDao.getLatestActiveProducts(3).size());
		
	}
}
