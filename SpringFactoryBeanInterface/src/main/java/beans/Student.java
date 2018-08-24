package beans;

public class Student {
	
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
	
	public Guardian getInstance() throws Exception
	{
		return (Guardian)Class.forName(guardianName).newInstance();
	}
	
}
