package beans;

public class Student {
	
	private static String name;
	
	private Student()
	{
		System.out.println("accessing private constructor");
	}
	
	public static void setName(String name) {
		Student.name = name;
	}
	public static void print()
	{
		System.out.println(name);
	}
}
