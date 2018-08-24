package com.stark.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stark.model.StudentDetail;
@Repository("studentDao")
public class StudentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void registerStudent(StudentDetail student) {

		Session session=getSessionFactory().openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
	
	public StudentDetail loginStudent(String name,String password) {
		
	
		Session session=getSessionFactory().openSession();
		Query q=session.createQuery("from StudentDetail where name=:name and password=:password");
		q.setParameter("name", name);
		q.setParameter("password", password);
		if(q.uniqueResult()!=null)
			return (StudentDetail) q.uniqueResult();

	return null;
}

	
}
