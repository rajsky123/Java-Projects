package com.shopping.app.categorydaoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shopping.app.categorydao.CategoryDao;
import com.shopping.app.dto.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao  {
	
	private static List<Category> categories=new ArrayList<>();
	
	static {
		
		Category category1=new Category();
		category1.setId(1);
		category1.setName("Television");
		category1.setDescription("This is tv");
		category1.setImageURL("CAT_1");
		
		categories.add(category1);
		
		Category category2=new Category();
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("This is mobile");
		category2.setImageURL("CAT_2");
		
		categories.add(category2);
		
		Category category3=new Category();
		category3.setId(3);
		category3.setName("Laptop");
		category3.setDescription("This is laptop");
		category3.setImageURL("CAT_3");
		
		categories.add(category3);
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.shopping.app.dto.CategoryDao#list()
	 */
	@Override
	public List<Category> list()
	{
	  return categories;
		
	}
	

}
