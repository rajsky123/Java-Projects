package com.shopping.app.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

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
		if (user.getRole().equals("USER")) {
			// create a new cart
			Cart cart = new Cart();
			cart.setUserId(user);
			user.setCart(cart);
		}
		
		//encode the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		// save the user
		userdao.addUser(user);
		// save the billing address
		Address billing = registerModel.getBilling();
		billing.setUserId(user);
		billing.setBilling(true);
		userdao.addAddress(billing);
		return transitionValue;
	}

	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("Password does not match confirm password!").build());
			transitionValue = "failure";
		}
		if(user.getEmail()!=null)
		if (userdao.getByEmail(user.getEmail())!=null) {
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email address is already taken!")
					.build());
			transitionValue = "failure";
		}
		return transitionValue;
	}

}
