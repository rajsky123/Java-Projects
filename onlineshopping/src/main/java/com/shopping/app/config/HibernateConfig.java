package com.shopping.app.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shopping.app.dto.Category;

@Configuration
@ComponentScan(basePackages= {"com.shopping.app.dto","com.shopping.app.categorydao","com.shopping.app.categorydaoimpl"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
	private static final String URL_="jdbc:mysql://localhost:3306/testdb";
	private static final String USERNAME="root";
	private static final String PASSWORD="tiger";
	
	@Bean(name ="dataSource")
	public DataSource getDataSource()
	{
	  DriverManagerDataSource dataSource=new DriverManagerDataSource();
	  dataSource.setDriverClassName(DRIVER_CLASS);
	  dataSource.setUrl(URL_);
	  dataSource.setUsername(USERNAME);
	  dataSource.setPassword(PASSWORD);
	  return dataSource;
	}
	
	@Bean(name ="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addAnnotatedClass(Category.class);
		builder.addProperties(getHibProperties());
		return builder.buildSessionFactory();
		
	}

	
	public Properties getHibProperties() {
		
		Properties properties=new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	@Bean
	   public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory)
	   {
		   HibernateTemplate hibernateTemplate=new HibernateTemplate(sessionFactory);
		   hibernateTemplate.setCheckWriteOperations(false);
		   return hibernateTemplate;
	   }

}
