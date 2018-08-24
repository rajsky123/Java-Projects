package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
	
	private int rollno;
	private String name;
	@Autowired(required=false)
	@Qualifier("pass2")
	private Passport passport;
	
	/*public void setPassport(Passport passport) {
		this.passport = passport;
	}*/
	
	private Student()  {
		System.out.println("acessesing private constructor");
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void print()
	{
		System.out.println(rollno);
		System.out.println(name);
		if(passport!=null)
		System.out.println(passport.getPassportId());
		else
			System.out.println("passport not been created");
	}
}
