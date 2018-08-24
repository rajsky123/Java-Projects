package com.stark.model;

import org.hibernate.validator.constraints.NotEmpty;

import com.stark.passwordvalidator.IsValidPassword;

public class Studentcredential {
	
	@NotEmpty
	private String name;
	@IsValidPassword
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
