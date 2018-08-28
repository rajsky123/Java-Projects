package com.shopping.app.categorydao;

import java.util.List;

import com.shopping.app.dto.Category;

public interface CategoryDao {

	List<Category> list();
	Category getById(int id);

}