package com.hib.java;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class GetDB {

	public static void main(String[] args) {

		
	
	
		
		SessionFactory sf=HibConfig.getSessionFactory();
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		
		Student st=session.get(Student.class,101);
		tx.commit();
		session.close();
		System.out.println(st);
	}

}
