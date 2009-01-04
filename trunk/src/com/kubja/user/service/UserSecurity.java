package com.kubja.user.service;

import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;

public class UserSecurity {
	private UserSecurity(){}
	public static String getLoggedInUser(){
		if(SecurityContextHolder.getContext().getAuthentication() == null){
			return null;
		}
		Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (obj instanceof UserDetails) {
		  username = ((UserDetails)obj).getUsername();
		} else {
		  username = obj.toString();
		}
		return username;
	}
	
	public static void logout(){
		SecurityContextHolder.getContext().setAuthentication(null);
	}
}
