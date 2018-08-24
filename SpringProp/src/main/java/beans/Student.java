package beans;


public class Student {
	
	private String rollno;
	private String name;
	private Passport passport;
	public Student(Passport passport,String rollno, String name) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.passport=passport;
	}
	
	public String getPassport() {
		
		return passport.getPassportId();
	}

	public String getRollno() {
		return rollno;
	}
	
	public String getName() {
		return name;
	}
}
