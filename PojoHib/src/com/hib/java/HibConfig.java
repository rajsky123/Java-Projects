package com.hib.java;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibConfig {
	
	private static SessionFactory SESSION_FACTORY;
	private static String s="com/hib/resourses/jspider.cfg.xml";

	

	public static SessionFactory getSessionFactory() {
		if(SESSION_FACTORY==null) {
			Configuration conf=new Configuration().configure(s).addAnnotatedClass(Student.class);
			SESSION_FACTORY=conf.buildSessionFactory();
			}
		return SESSION_FACTORY;
	}
	

}
