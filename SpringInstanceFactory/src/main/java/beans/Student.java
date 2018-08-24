package beans;

public class Student {
	
	private static String guardianName;
	
	private Student()
	{
		System.out.println("accessing private constructor");
	}
	
	public static void setGuardianName(String guardianName) {
		Student.guardianName = guardianName;
	}
	public static void print()
	{
		System.out.println(guardianName);
	}
	
	public static Guardian getInstance() throws Exception
	{
		return (Guardian)Class.forName(guardianName).newInstance();
	}
	
}
