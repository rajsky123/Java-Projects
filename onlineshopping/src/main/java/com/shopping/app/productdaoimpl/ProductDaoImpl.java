package com.shopping.app.productdaoimpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.app.dto.Product;
import com.shopping.app.productdao.ProductDao;

@Repository("productdao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private HibernateTemplate 	template;
	
	
	@Override
	public Product get(int productId) {

		Product product = template.get(Product.class, productId);
		return product;
					
	}

	@Override
	public List<Product> list() {

		 DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		 List<Product> findByCriteria = (List<Product>) template.findByCriteria(criteria);
		return findByCriteria;
	}

	@Override
	public boolean add(Product product) {

		Integer productAdd  = (Integer) template.save(product);
		
		if(productAdd!=null)
			return true;
		
		return false;
	}

	@Override
	public boolean update(Product product) {
      
		 template.update(product);
		return true;
	}

	@Override
	public boolean delete(Product product) {

		product.setActive(false);
		template.update(product);
		return true;
	}

	@Override
	public List<Product> listActiveProducts() {
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("active", true));
		List<Product> findByCriteria = (List<Product>) template.findByCriteria(criteria);
		return findByCriteria;
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("active", true));
		criteria.add(Restrictions.eq("categoryId", categoryId));
		List<Product> findByCriteria = (List<Product>) template.findByCriteria(criteria);
		return findByCriteria;
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		criteria.add(Restrictions.eq("active", true));
		criteria.addOrder(Order.asc("id"));
		List<Product> findByCriteria = (List<Product>) template.findByCriteria(criteria,0,count);
		return findByCriteria;
	}

}
