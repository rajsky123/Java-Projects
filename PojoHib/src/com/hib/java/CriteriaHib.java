package com.hib.java;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class CriteriaHib {
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibConfig.getSessionFactory();
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Student.class);
		//cr.add(Restrictions.like("name", "bis%"));
		//cr.setProjection(Projections.max("perc"));
		cr.addOrder(Order.asc("perc"));
		cr.setFirstResult(1);
		cr.setMaxResults(3);
		List st=cr.list();
		
		for(Object ss:st)
			System.out.println(ss);
		
		
	}
}
