package beans;

import org.springframework.beans.factory.FactoryBean;

public class Student implements FactoryBean {
	
	private String guardianName;
	
	private Student()
	{
		System.out.println("accessing private constructor");
	}
	
	public void setGuardianName(String guardianName) {
		this.guardianName= guardianName;
	}
	public void print()
	{
		System.out.println(guardianName);
	}

	public Object getObject() throws Exception {
     
		return Class.forName(guardianName).newInstance();
	}

	public Class getObjectType() {
		return Guardian.class;
	}

	public boolean isSingleton() {
		return true;
	}
	
	
	
}
