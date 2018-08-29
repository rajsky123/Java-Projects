package com.shopping.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.app.categorydao.CategoryDao;
import com.shopping.app.dto.Category;

public class TestCategory {
	
	private static AnnotationConfigApplicationContext ctx;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.shopping.app");
		ctx.refresh();
		
		categoryDao = ctx.getBean(CategoryDao.class);
	}
	
	@org.junit.Test
	public void addCategory() {
		category=new Category();
		
		category.setName("Television");
		category.setDescription("This is tv");
		category.setImageURL("CAT_1");
		
		assertEquals("Something went wrong", true, categoryDao.add(category));
		
	}

}
