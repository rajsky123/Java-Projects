package com.shopping.app.categorydao;

import java.util.List;

import com.shopping.app.dto.Address;
import com.shopping.app.dto.Cart;
import com.shopping.app.dto.User;

public interface UserDao {

	
	//add an user
	boolean addUser(User user);
	
	//add an address
	boolean addAddress(Address address);
	//get billing address by user
	Address getBillingAddress(User user);
	
	//get list of shipping address of a user
	List<Address> listShippingAddress(User user);
	
	//add a cart
	boolean updateCart(Cart cart);
	
	//get user by email
	User getByEmail(String email);
	
}
