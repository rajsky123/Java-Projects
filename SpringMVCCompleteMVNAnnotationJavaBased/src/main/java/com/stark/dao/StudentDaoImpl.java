package com.stark.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.stark.model.StudentDetail;
@Repository
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
    private HibernateTemplate hibernateTemplate;
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	@Transactional
	public void registerStudent(StudentDetail student) {
       
		hibernateTemplate.save(student);
	}
	
	
	@SuppressWarnings("unchecked")
	public StudentDetail loginStudent(String name,String password) {
		
	   
		
		DetachedCriteria detachedCriteria =  DetachedCriteria.forClass(StudentDetail.class);
		detachedCriteria.add(Restrictions.eq("name", name));
		detachedCriteria.add(Restrictions.eq("password", password));
		List<StudentDetail> findByCriteria = (List<StudentDetail>) hibernateTemplate.findByCriteria(detachedCriteria);
		if(findByCriteria !=null && findByCriteria.size()>0)
		return findByCriteria.get(0);
		else
			return null;}

	
}
