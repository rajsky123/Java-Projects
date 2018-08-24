package Config;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import Business.Bank;
import Service.LogAfterMethod;

@Configuration
@ComponentScan(basePackages= {"Business","Service"})
public class TestConfig {

	@Autowired
	Bank bank;
	
	@Autowired
	LogAfterMethod afterMethod;
	
	
	
	
	
	@Bean
	public NameMatchMethodPointcut nmmp()
	{
		NameMatchMethodPointcut nameMatchMethodPointcut=new NameMatchMethodPointcut();
		nameMatchMethodPointcut.addMethodName("deposit");
		
		return nameMatchMethodPointcut;
	}
	
	@Bean
	public DefaultPointcutAdvisor advisor(NameMatchMethodPointcut nmmp)
	{
			DefaultPointcutAdvisor dpa=new DefaultPointcutAdvisor();
			dpa.setPointcut(nmmp);
			dpa.setAdvice(afterMethod);
			return dpa;
	}
	@Bean
	public ProxyFactory bean(DefaultPointcutAdvisor advisor)
	{
		ProxyFactory bean=new ProxyFactory();
		bean.setTarget(bank);
		bean.addAdvisor(advisor);
        return bean;		
	}
}
