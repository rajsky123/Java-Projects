package com.hib.java;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Laptop lp1=new Laptop();
		lp1.setLapName("lenovo");
		
		Laptop lp2=new Laptop();
		lp2.setLapName("dell");
		
		Laptop lp3=new Laptop();
		lp3.setLapName("hp");
		
		Student st=new Student();
		st.setStudName("jagdev");
		st.setStudPerc(85.20);
        st.getLaptop().add(lp1);	
        st.getLaptop().add(lp2);
        st.getLaptop().add(lp3);
        lp1.setSt(st);
        lp2.setSt(st);
        lp3.setSt(st);
		Configuration conf=new Configuration().configure("com/hib/resources/hib.cfg.xml")
				.addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf=conf.buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(st);
		tx.commit();
		
		
		
	}

}
