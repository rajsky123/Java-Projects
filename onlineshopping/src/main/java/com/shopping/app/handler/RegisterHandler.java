package com.shopping.app.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shopping.app.categorydao.UserDao;
import com.shopping.app.dto.Address;
import com.shopping.app.dto.Cart;
import com.shopping.app.dto.User;
import com.shopping.app.model.RegisterModel;

@Component
public class RegisterHandler {

	@Autowired
	private UserDao userdao;
	
	
	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	
	public String saveAll(RegisterModel registerModel) {
		  String transitionValue = "success";
		  User user = registerModel.getUser();
		  if(user.getRole().equals("USER")) {
		   // create a new cart
		   Cart cart = new Cart();
		   cart.setUserId(user);
		   user.setCart(cart);
		  }
		   
		  
		  // save the user
		  userdao.addUser(user);
		  // save the billing address
		  Address billing = registerModel.getBilling();
		  billing.setUserId(user);
		  billing.setBilling(true);  
		  userdao.addAddress(billing);
		  return transitionValue ;
		} 

}
