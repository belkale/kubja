package com.kubja.user.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.kubja.user.domain.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User)target;
		if(u == null){
			errors.rejectValue(null, null, "User should be specified");
		} else {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", null, "Required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", null, "Required");
		}
	}

}
