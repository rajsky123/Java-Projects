package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println("-----------car-------------");
		 Car c=(Car) context.getBean("c");
		 System.out.println(c.getClass().getCanonicalName());
		 System.out.println(c.myEngine().getEngineName());
		
		 System.out.println("-----------Bus-------------");
		 Bus b=(Bus) context.getBean("b");
		 System.out.println(b.getClass().getCanonicalName());
		 System.out.println(b.myEngine().getEngineName());
		 
		 System.out.println("-----------Truck-------------");
		 Truck t=(Truck) context.getBean("t");
		 System.out.println(t.getClass().getCanonicalName());
		 System.out.println(t.myEngine().getEngineName());
		((AbstractApplicationContext) context).close();

	}

}
