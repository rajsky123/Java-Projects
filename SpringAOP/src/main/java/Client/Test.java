package Client;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Business.Bank;
import Config.TestConfig;
import Exception.ActNoInvalid;

public class Test {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(TestConfig.class);
		ProxyFactory pf = (ProxyFactory)ctx.getBean("bean");
		
		 Bank b=(Bank)pf.getProxy();
		 try {
			//System.out.println(b.checkBalance("sbi123"));
			System.out.println(b.deposit("sbi123",5000));
		} catch (ActNoInvalid e) {
			System.out.println(e.getMessage());
		}
		 finally {
			ctx.close();
		}
	}

}
