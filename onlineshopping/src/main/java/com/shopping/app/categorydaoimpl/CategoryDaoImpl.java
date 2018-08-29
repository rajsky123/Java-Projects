package com.shopping.app.categorydaoimpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.app.categorydao.CategoryDao;
import com.shopping.app.dto.Category;

@Repository("categorydao")
public class CategoryDaoImpl implements CategoryDao  {
	
	
	
	@Autowired
	private HibernateTemplate template;
	
	private List<Category> categories;
	/* 
	 * to fetch list of categories
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list()
	{
		
		DetachedCriteria criteria=DetachedCriteria.forClass(Category.class);
		criteria.add(Restrictions.eq("active", true));
		categories= (List<Category>) template.findByCriteria(criteria);
		
		
	  return categories;
		
	}

	
	//to fetch single category
	@Override
	public Category getById(int id) {
		
		for (Category category : categories) {
			if(category.getId()==id)
				return category;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {

		try {
			//add category to DB
			//sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	

}
