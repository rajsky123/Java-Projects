package com.hib.java;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;

public class PKHQL implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		Integer st;
		try {
		Query qry=arg0.createQuery("select max(id) from Student");
		st=(Integer)qry.uniqueResult()+5;
		}catch (Exception e) {
			return 1;
		}
		
		return st;
	}

}
