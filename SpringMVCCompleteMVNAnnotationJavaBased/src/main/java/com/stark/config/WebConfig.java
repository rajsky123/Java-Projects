package com.stark.config;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.stark.model.StudentDetail;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:/com/stark/properties/database.properties" })
@ComponentScan(basePackages= {"com.stark.controller","com.stark.dao","com.stark.model","com.stark.config"})
public class WebConfig {
	
	@Value(value="${db.driver.name}")
	private String driverClassName;
	@Value(value="${db.url}")
	private String url;
	@Value(value="${db.username}")
	private String username;
	@Value(value="${db.password}")
	private String password;
	@Bean
	public InternalResourceViewResolver resourceViewResolver()
	{
		InternalResourceViewResolver resourceViewResolver=new InternalResourceViewResolver();
		resourceViewResolver.setViewClass(JstlView.class);
		resourceViewResolver.setPrefix("/WEB-INF/views/");
		resourceViewResolver.setSuffix(".jsp");
		return resourceViewResolver;
		
	}
	@Bean(name = "dataSource")
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyPlaceholder()
	{
		return new PropertySourcesPlaceholderConfigurer();
		
	}
	
   @Bean(name = "sessionFactory")
   public SessionFactory getSessionfactoryBean(DataSource dataSource)
   {
	   LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(dataSource);
	   factoryBuilder.addAnnotatedClass(StudentDetail.class);
	   return factoryBuilder.buildSessionFactory();
   }
   
   @Bean
   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
   {
       HibernateTransactionManager transactionManager = new HibernateTransactionManager(
               sessionFactory);
    
       return transactionManager;
   }
   
   
   @Bean
   public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory)
   {
	   HibernateTemplate hibernateTemplate=new HibernateTemplate(sessionFactory);
	   hibernateTemplate.setCheckWriteOperations(false);
	   return hibernateTemplate;
   }
   
   @Bean
   public MessageSource messageSource()
   {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setCacheSeconds(0);
		return messageSource;
   }
   
  
  
}
