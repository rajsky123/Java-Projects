package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.test;


public class client {
	
	public static void main(String[] args) {
		
	//String files[]=new String[]{"resourses/spring.xml","resourses/engine.xml"};
	String files="resourses/spring.xml";
	ApplicationContext ac= new ClassPathXmlApplicationContext(files);
	
	test t=(test)ac.getBean("t");
	t.getName();

	

}
}