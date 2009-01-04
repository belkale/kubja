package com.kubja.user.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;

public class User implements Serializable, UserDetails {
	private String login;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Date dob;
	private Address address = new Address();
	
	private boolean enabled;
	private String authStr;
	
	//authorities is provided for local caching of processed result
	private GrantedAuthority[] authorities;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public GrantedAuthority[] getAuthorities() {
		if(authStr == null){
			return null;
		}
		if(authorities != null){
			return authorities;
		}
		String[] authArr = authStr.split(",");
		GrantedAuthority[] auths = new GrantedAuthority[authArr.length];
		for(int i=0; i< authArr.length; i++){
			auths[i] = new GrantedAuthorityImpl(authArr[i]);
		}
		authorities = auths;
		return auths;
	}
	@Override
	public String getUsername() {
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	public String getAuthStr() {
		return authStr;
	}
	public void setAuthStr(String authStr) {
		this.authStr = authStr;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setAuthorities(GrantedAuthority[] authorityObjs) {
		authorities = authorityObjs;
		StringBuilder auths = new StringBuilder();
		for(GrantedAuthority a: authorityObjs){
			auths.append(a.getAuthority() + ",");
		}
		if(auths.length() > 0){
			auths.deleteCharAt(auths.length() - 1);
		}
		authStr = auths.toString();

	}
	
}
