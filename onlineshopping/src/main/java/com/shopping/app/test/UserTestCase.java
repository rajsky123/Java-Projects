package com.shopping.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.app.categorydao.UserDao;
import com.shopping.app.dto.Address;
import com.shopping.app.dto.Cart;
import com.shopping.app.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDao userdao;
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shopping.app");
		context.refresh();
		
		userdao = context.getBean(UserDao.class);
}
	
/*	@Test
	public void testAddAddress()
	{
		
		//add user
		user = new User() ;
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		assertEquals("Something went wrong for user", true,userdao.addUser(user));
		
		
		//add billing address
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		address.setUserId(user);
		
		assertEquals("Something went wrong for address", true,userdao.addAddress(address));
		
		//add shipping address
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		
		address.setUserId(user);
		
		assertEquals("Something went wrong for address", true,userdao.addAddress(address));
		
	}*/
	
	@Test
	public void testAddAddressByUser()
	{
		user=userdao.getByEmail("hr@gmail.com");
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Bangalore");
		address.setState("Karnatak");
		address.setCountry("India");
		address.setPostalCode("560037");
		address.setShipping(true);
		
		address.setUserId(user);
		
		assertEquals("Something went wrong for address",true,userdao.addAddress(address));
		
		
		
	}
}
