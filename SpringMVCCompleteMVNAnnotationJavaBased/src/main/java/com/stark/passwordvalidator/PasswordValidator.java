package com.stark.passwordvalidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<IsValidPassword, String>{
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private Pattern pattern;
	private Matcher matcher;
	
	public PasswordValidator() {
	
		 pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	public void initialize(IsValidPassword isValidPassword) {

		isValidPassword.message();
	}

	public boolean isValid(String password, ConstraintValidatorContext context) {
		   if(password == null) {
	            return false;
	        }
	        matcher = pattern.matcher(password);
	        return matcher.matches();
	}
	
       }
