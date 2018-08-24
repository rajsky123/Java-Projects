package beans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	  Student st= (Student) context.getBean(Student.class);
	  
	 System.out.println(st.getRollno());
	 System.out.println(st.getName());
	 System.out.println(st.getPassport());
	 ((AbstractApplicationContext) context).close();
	
	}

}
