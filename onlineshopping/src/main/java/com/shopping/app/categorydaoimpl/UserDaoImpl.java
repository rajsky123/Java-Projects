package com.shopping.app.categorydaoimpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.app.categorydao.UserDao;
import com.shopping.app.dto.Address;
import com.shopping.app.dto.Cart;
import com.shopping.app.dto.User;

@Repository("userdao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate template;
	
	@Override
	public boolean addUser(User user) {

		try {
			
			template.save(user);
			return true;
		} catch (Exception e) {
            e.printStackTrace();
			return true;
		}
	}

	@Override
	public boolean addAddress(Address address) {
try {
			
			template.save(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
try {
			
			template.update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}

	@Override
	public User getByEmail(String email) {

		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("email", email));
		List<User> list = (List<User>) template.findByCriteria(criteria);
		if(list.size()==0)
			return null;
		
		return list.get(0);
	}

	@Override
	public Address getBillingAddress(User user) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Address.class);
		criteria.add(Restrictions.eq("userId", user));
		criteria.add(Restrictions.eq("billing", true));
		List<Address> list=(List<Address>)template.findByCriteria(criteria);
		
		return list.get(0);
	}

	@Override
	public List<Address> listShippingAddress(User user) {
		DetachedCriteria criteria=DetachedCriteria.forClass(Address.class);
		criteria.add(Restrictions.eq("userId", user));
		criteria.add(Restrictions.eq("shipping", true));
		List<Address> list=(List<Address>) template.findByCriteria(criteria);
		return list;
	}

}
