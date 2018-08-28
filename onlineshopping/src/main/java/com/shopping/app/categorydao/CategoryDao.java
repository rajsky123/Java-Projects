package com.shopping.app.categorydao;

import java.util.List;

import com.shopping.app.dto.Category;

public interface CategoryDao {

	boolean add(Category category);
	List<Category> list();
	Category getById(int id);

}