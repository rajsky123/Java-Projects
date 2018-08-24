package com.hib.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class PushDB {

	public static void main(String[] args) {

		
		
		SessionFactory sf=HibConfig.getSessionFactory();
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Student st=new Student();
		st.setName("jambannew");
		st.setPerc(35.87);
		session.save(st);
		tx.commit();
		System.out.println(st);
		
		
	}

}
