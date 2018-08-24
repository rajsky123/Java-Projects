package beans;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		 Utility u=ac.getBean(Utility.class);
		 u.print();
		 ac.close();
		
	}

}
