package beans;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) throws SQLException {
		
		ConfigurableApplicationContext cc=new ClassPathXmlApplicationContext("spring.xml");
		Student t=(Student) cc.getBean("t");
		while(true)
		{
			System.out.println("Enter 1 to insert 2 to exit");
			Scanner sc=new Scanner(System.in);
			int i=sc.nextInt();
			switch (i) {
			case 1:System.out.println("Enter rollno:");
					int id=sc.nextInt();
					System.out.println("Enter name:");
					String name=sc.next();
					System.out.println("Enter marks:");
					double marks=sc.nextDouble();
				t.save(id, name, marks);	
				
				break;

			default: cc.close();
			         t=null;
				break;
			}
			if(t==null)break;
		}
		
	}

}
